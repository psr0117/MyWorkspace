package com.batch.demo.config;


import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.batch.demo.domain.Fund;
import com.batch.demo.processors.FundProcessor;

//https://howtodoinjava.com/spring-batch/csv-to-database-java-config-example/

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Value("classPath:/input/inputData.csv")
	private Resource inputResource;

	// First create a JOb bean to read the CSV File

	@Bean
	public Job CSVFileReaderJob(Step step) {

		return jobBuilderFactory
				.get("CSVJOB")
				.incrementer(new RunIdIncrementer())
				.start(step())
				.build();

	}

	// IN each step, we wil read, process and write
	@Bean
	public Step step() {
		return stepBuilderFactory.get("JobStep").<Fund, Fund>chunk(10).reader(csvReader()).processor(processor())
				.writer(writer()).build();
	}

	@Bean
	public ItemProcessor<Fund, Fund> processor() {
		return new FundProcessor();
	}

	
	@Bean
	public FlatFileItemReader<Fund> csvReader() {
		FlatFileItemReader<Fund> itemReader = new FlatFileItemReader<Fund>();
		itemReader.setResource(inputResource);
		itemReader.setLineMapper(lineMapper());
		itemReader.setLinesToSkip(1); // header
		return itemReader;

	}

	@Bean
	public LineMapper<Fund> lineMapper() {
		DefaultLineMapper<Fund> defaultLineMapper = new DefaultLineMapper<Fund>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "symbol", "cusip", "name" });
		lineTokenizer.setIncludedFields(new int[] { 0, 1, 2 });
		BeanWrapperFieldSetMapper<Fund> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<Fund>();
		beanWrapperFieldSetMapper.setTargetType(Fund.class);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		return defaultLineMapper;

	}

	@Bean
	public JdbcBatchItemWriter<Fund> writer() {
		JdbcBatchItemWriter<Fund> jdbcBatchItemWriter = new JdbcBatchItemWriter<Fund>();
		jdbcBatchItemWriter.setDataSource(dataSource());
		jdbcBatchItemWriter.setSql("Insert into Fund_info(Symbol, Cusip, Name) Values (:symbol, :cusip, :name)");
		jdbcBatchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Fund>());
		return jdbcBatchItemWriter;

	}

	@Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        return embeddedDatabaseBuilder.addScript("classpath:org/springframework/batch/core/schema-drop-h2.sql")
                .addScript("classpath:org/springframework/batch/core/schema-h2.sql")
                .addScript("classpath:fund.sql")
                .setType(EmbeddedDatabaseType.H2) 
                .build();
    }
	 

}
