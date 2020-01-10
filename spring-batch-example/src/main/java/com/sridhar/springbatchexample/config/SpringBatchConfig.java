package com.sridhar.springbatchexample.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.sridhar.springbatchexample.model.User;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	@Bean
	public Job myjob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
						ItemReader<User> itemReader,
						ItemProcessor<User, User> itemProcessor,
						ItemWriter<User> itemWriter) {
		
		Step step = (Step) stepBuilderFactory.get("ETL-file-load")
				.<User, User>chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
				;
		
		
		return (Job) jobBuilderFactory
				.get("ETL-Load")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}
	
	@Bean
	public FlatFileItemReader<User> itemReader(@Value("{inputResource}") Resource resource){
		
		FlatFileItemReader<User> itemReader = new FlatFileItemReader<User>();
		itemReader.setResource(new FileSystemResource("src/main/resources/users.csv"));
		itemReader.setName("CSV Reader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		return itemReader;
		
	}

	public LineMapper<User> lineMapper() {
		// TODO Auto-generated method stub
		DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<User>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"id","name","dept","salary"});
		lineTokenizer.setIncludedFields(new int[] {0,1,2,3});
		
		BeanWrapperFieldSetMapper<User> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<User>();
		beanWrapperFieldSetMapper.setTargetType(User.class);
		
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		
		return defaultLineMapper;
	}
}
