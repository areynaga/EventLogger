package be.steria.datapoc.EventLogger.text;

import java.util.logging.FileHandler;
import java.util.logging.Logger;



import be.steria.datapoc.EventLogger.model.NodeEvent;

public class TextLogger {
	
	

	public TextLogger(String logFileName, String append) {
		FileHandler handler;
		try {
			
			handler = new FileHandler(logFileName, append.equals("true"));
			Logger logger = Logger.getLogger("EventLogger");
			handler.setFormatter(new TextLoggerFormat());
			logger.addHandler(handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void logEvent(NodeEvent nodeEvent) throws Exception {
		Logger logger = Logger.getLogger("EventLogger");
		StringBuffer sb = new StringBuffer(500);
		sb.append(nodeEvent.getNodeId().trim());
		sb.append(",");
		sb.append(nodeEvent.getNodeEventType().toString());
		sb.append(",\"");
		sb.append(nodeEvent.getMessage().trim());
		sb.append("\"");
		logger.info(sb.toString());
		
	}

}
