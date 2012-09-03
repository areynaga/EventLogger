package be.steria.datapoc.EventLogger.text;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class TextLoggerFormat extends Formatter {

	// Append a two digit number.
	private void a2(StringBuffer sb, int x) {
		if (x < 10) {
			sb.append('0');
		}
		sb.append(x);
	}

	// Append the time and date in ISO 8601 format
	@SuppressWarnings({ "unused", "deprecation" })
	private void appendISO8601(StringBuffer sb, long millis) {
		Date date = new Date(millis);
		sb.append(date.getYear() + 1900);
		sb.append('-');
		a2(sb, date.getMonth() + 1);
		sb.append('-');
		a2(sb, date.getDate());
		sb.append(' ');
		a2(sb, date.getHours());
		sb.append(':');
		a2(sb, date.getMinutes());
		sb.append(':');
		a2(sb, date.getSeconds());
	}


	@Override
	public String format(LogRecord record) {
		StringBuffer sb =  new StringBuffer(1000);

		sb.append(record.getSequenceNumber());
		sb.append(",");

		appendISO8601(sb, record.getMillis());
		sb.append(",");

		sb.append(record.getMessage());
		sb.append("\n");


		return sb.toString();
	}

}
