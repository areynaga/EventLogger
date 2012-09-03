package be.steria.datapoc.EventLogger.text;

public class LoggerProperties {
	private String filename;
	private String append;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getAppend() {
		return append;
	}
	public void setAppend(String append) {
		this.append = append;
	}
}
