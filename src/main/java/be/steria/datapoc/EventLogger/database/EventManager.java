package be.steria.datapoc.EventLogger.database;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import be.steria.datapoc.EventLogger.model.NodeEvent;
import be.steria.datapoc.EventLogger.model.NodeEventReg;


public class EventManager {
	
	private EventDao eventDao;
	
	
	@Transactional
	public void registerEvent(NodeEvent nodeEvent) {
		NodeEventReg nodeEventReg = new NodeEventReg();
		nodeEventReg.setNodeId(nodeEvent.getNodeId());
		nodeEventReg.setMessage(nodeEvent.getMessage());
		nodeEventReg.setNodeEventType(nodeEvent.getNodeEventType());
		nodeEventReg.setDate(new java.util.Date());
		eventDao.insertEvent(nodeEventReg);
	}


	public List<NodeEventReg> getEvents(String nodeId, Date fromDate, Date toDate) {
		return eventDao.getEventsByDateNode(nodeId, fromDate, toDate);
	}
	
	public EventDao getEventDao() {
		return eventDao;
	}


	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}
}
