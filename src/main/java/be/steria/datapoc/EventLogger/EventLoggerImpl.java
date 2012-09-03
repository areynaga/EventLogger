package be.steria.datapoc.EventLogger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import be.steria.datapoc.EventLogger.database.EventManager;
import be.steria.datapoc.EventLogger.model.NodeEvent;
import be.steria.datapoc.EventLogger.model.NodeEventReg;
import be.steria.datapoc.EventLogger.text.TextLogger;


@SuppressWarnings("restriction")
@WebService
public class EventLoggerImpl implements EventLogger {

	@Autowired
	private EventManager eventManager;
	
	@Autowired
	private TextLogger textLogger;
	
	public void logEvent(@WebParam(name = "event") NodeEvent nodeEvent) throws RuntimeException {
		try {
			textLogger.logEvent(nodeEvent);
			eventManager.registerEvent(nodeEvent);
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<NodeEventReg> getEventLogs(@WebParam(name = "nodeId") String nodeId,
			@WebParam(name = "fromDate") String fromDate,
			@WebParam(name = "toDate") String toDate)  {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
		
		try {
			Date initDate = (fromDate!=null)?dateFormat.parse(fromDate):null;
			Date endDate = (toDate!=null)?dateFormat.parse(toDate):null;
			
			return eventManager.getEvents(nodeId, initDate, endDate);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}
	
	
	public TextLogger getTextLogger() {
		return textLogger;
	}

	public void setTextLogger(TextLogger textLogger) {
		this.textLogger = textLogger;
	}

	public EventManager getEventManager() {
		return eventManager;
	}

	public void setEventManager(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	
	
}
