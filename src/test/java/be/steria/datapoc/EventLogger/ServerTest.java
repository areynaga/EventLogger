package be.steria.datapoc.EventLogger;


import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import be.steria.datapoc.EventLogger.model.NodeEvent;
import be.steria.datapoc.EventLogger.model.NodeEventReg;
import be.steria.datapoc.EventLogger.model.NodeEventType;



public class ServerTest{

	private Server server;
	private int actualPort;
	
	@Before
	public void startJetty() throws Exception {
		
		
		
		server = new Server(0);   
	    server.setHandler(new WebAppContext("src/main/webapp", "/Logger")); 
	    
	    
	    
	    server.start();
	    actualPort = server.getConnectors()[0].getLocalPort();
	    System.out.println("Server started");
	}
	
	@After
	public void stopJetty() throws Exception {
		server.stop();
	}
	
	@Test
	public void test() throws Exception {
		JaxWsProxyFactoryBean clientFactory = new JaxWsProxyFactoryBean();
        clientFactory.setAddress("http://localhost:" + actualPort + "/Logger/services/Logger");
		clientFactory.setServiceClass(EventLogger.class);
		EventLogger eventLogger = (EventLogger) clientFactory.create();
		NodeEvent event = new NodeEvent("1", NodeEventType.CREATION, "Event one"); 
		
		eventLogger.logEvent(event);
		
		List<NodeEventReg> events = eventLogger.getEventLogs("1", null, null);
		
		Assert.assertEquals(event.getNodeId(), events.get(0).getNodeId());
		Assert.assertEquals(event.getNodeEventType().toString(), 
				events.get(0).getNodeEventType().toString());
		
	}
	
	
}
