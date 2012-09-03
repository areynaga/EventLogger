package be.steria.datapoc.EventLogger;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import be.steria.datapoc.EventLogger.model.NodeEvent;
import be.steria.datapoc.EventLogger.model.NodeEventReg;

@SuppressWarnings("restriction")
@WebService
public interface EventLogger {
	public void logEvent(@WebParam(name="event") NodeEvent nodeEvent) throws RuntimeException;
	public List<NodeEventReg> getEventLogs(@WebParam(name="nodeId") String nodeId,
			@WebParam(name="fromDate") String fromDate, @WebParam(name="toDate") String toDate);
}
