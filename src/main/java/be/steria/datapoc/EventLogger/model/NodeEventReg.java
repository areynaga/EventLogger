package be.steria.datapoc.EventLogger.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="NODE_EVENT_REG")
public class NodeEventReg extends NodeEvent {
	
	@Id
	@Column(name="SEQUENCE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long sequence;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	
	@Transient
	private String stringDate;
	
	
	

	public String getStringDate() {
		if (date != null) {
			SimpleDateFormat dateformat =  new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss:SSS");
			return dateformat.format(date);
		} else {
			return null;
		}
			
		
	}


	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}


	public long getSequence() {
		return sequence;
	}


	public void setSequence(long sequence) {
		this.sequence = sequence;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
