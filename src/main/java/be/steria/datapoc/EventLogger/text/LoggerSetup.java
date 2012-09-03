package be.steria.datapoc.EventLogger.text;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerSetup {
	static private FileHandler fileTxt;
	static private SimpleFormatter formatterTxt;


	static public void setup() throws IOException {
		// Create Logger
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.INFO);
		fileTxt = new FileHandler("Logging.txt");


		// Create txt Formatter
		formatterTxt = new SimpleFormatter();
		fileTxt.setFormatter(formatterTxt);
		logger.addHandler(fileTxt);


	}
}
