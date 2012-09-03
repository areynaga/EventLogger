package be.steria.datapoc.EventLogger.database;

import java.util.Date;
import java.util.List;

import be.steria.datapoc.EventLogger.model.NodeEventReg;

public interface EventDao {
	public void insertEvent(NodeEventReg nodeEventReg);
	public List<NodeEventReg> getEventsByDateNode(String nodeId, Date initDate, Date endDate);
}
