package be.steria.datapoc.EventLogger.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;


@MappedSuperclass
public class NodeEvent {
	
	@Column(name="NODE_ID")
	private String nodeId;
	
	@Transient
	private NodeEventType nodeEventType;
	
	@Column(name="EVENT_TYPE")
	private String eventType;
	
	private String message;
	
	public NodeEvent() {
		
	}
	
	@PrePersist
    void populateDBFields(){
        eventType = nodeEventType.toString();
    }

    @PostLoad
    void populateTransientFields(){
        nodeEventType = NodeEventType.valueOf(eventType);
    }

	
	
	public NodeEvent(String nodeId, NodeEventType nodeEventType, String message) {
		super();
		this.nodeId = nodeId;
		this.nodeEventType = nodeEventType;
		this.message = message;
	}




	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public NodeEventType getNodeEventType() {
		return nodeEventType;
	}




	public void setNodeEventType(NodeEventType nodeEventType) {
		this.nodeEventType = nodeEventType;
	}
	
}
