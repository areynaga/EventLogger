package be.steria.datapoc.EventLogger.database;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import be.steria.datapoc.EventLogger.model.NodeEventReg;

public class EventDaoImpl implements EventDao {
	protected EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	public void insertEvent(NodeEventReg nodeEventReg) {
		entityManager.persist(nodeEventReg);
	}
	
	@SuppressWarnings("unchecked")
	public List<NodeEventReg> getEventsByDateNode(String nodeId, Date initDate, Date endDate) {
		Query qry = null;
		
		if (initDate == null || endDate == null) {
			qry = entityManager.createQuery("select o from NodeEventReg o where " + 
					"(o.nodeId = :nodeId or :nodeId = '%')");
			qry.setParameter("nodeId", nodeId);
		}
			
		else {
			qry = entityManager.createQuery("select o from NodeEventReg o where " + 
					"(o.nodeId = :nodeId or :nodeId = '%') and o.date between :initDate and :endDate");
			qry.setParameter("nodeId", nodeId);
			qry.setParameter("initDate", initDate);
			qry.setParameter("endDate", endDate);
		}
			
		
		return qry.getResultList();
	}
}
