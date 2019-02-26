package demo;

import com.intuit.karate.junit4.Karate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.ServerStart;


@RunWith(Karate.class)
public abstract class TestBase {
    
	 private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    private static ServerStart server;
    
    public static int startServer() throws Exception {
    	
    	logger.info("starting server ......... ");
        if (server == null) { // keep spring boot side alive for all tests including package 'mock'
        	logger.info("server object is null..........");
        	
            server = new ServerStart();
            logger.info("servicer start object--------- "+server);
            server.start(new String[]{"--server.port=0"}, false);
        }
        logger.info("demo.server.port " + server.getPort() + "");
        
        System.setProperty("demo.server.port", server.getPort() + "");
        return server.getPort();        
    }
    
    @BeforeClass
    public static void beforeClass() throws Exception {
        startServer();
    }
    
    public static void stopServer() throws Exception {
          
    }
    
    @AfterClass
    public static void afterClass() throws Exception{
    	
    }
   
    
}
