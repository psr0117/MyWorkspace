package com.cxf.main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServerImpl {
	//https://dkovalsky.blogspot.com/search?q=cxf
	
	public final String TEST_CONTEXT = "/spring-cxf-rest-example-embedded-jetty";
    public final int TEST_PORT = 8083;
    private Server jettyServer;
    private String mode;
	    
   public JettyServerImpl() {
	   
   }
   
 public JettyServerImpl(String mode) {
	 this.mode = mode;
	   
   }
 
 public void Start() throws Exception {
	 if (jettyServer == null) {
		 jettyServer = new Server(TEST_PORT);
		 WebAppContext  jettyContext = new WebAppContext();
		 jettyContext.setDescriptor("src/main/webapp/WEB-INF/web.xml");
		 jettyContext.setContextPath(TEST_CONTEXT);
		 jettyContext.setResourceBase("src/main/webapp");
		 jettyContext.setParentLoaderPriority(true);
		 jettyServer.setHandler(jettyContext);
		 jettyServer.start();

         System.out.println("Server started at http://localhost:"+TEST_PORT+TEST_CONTEXT);
         if (mode==null || !mode.equals("JUNIT")) {
        	 jettyServer.join();
         }
         
		 
	 }
	 
 }
 
 public void stop() throws Exception
 {
     if (jettyServer != null)
     {
    	 jettyServer.stop();
    	 jettyServer.join();
    	 jettyServer.destroy();
    	 jettyServer = null;
     }
 }
 

}
