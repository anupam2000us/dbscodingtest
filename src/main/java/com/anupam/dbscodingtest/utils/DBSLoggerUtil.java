/**
 * 
 */
package com.anupam.dbscodingtest.utils;

import java.io.IOException;
import java.util.logging.*;

/**
 * @author Anupam
 *
 */
public class DBSLoggerUtil {
	private static Logger LOGGER = Logger.getLogger(DBSLoggerUtil.class.getName());
	private static Handler h = null;
	private static Formatter f = null;
	
	public DBSLoggerUtil(String src) {
		LOGGER = Logger.getLogger(src);
	}
	
	
	public void log(Level logLevel, String message, String src) {
		try{
            
            h = new FileHandler("dbslogger.txt");
            f = new SimpleFormatter();
             
            LOGGER.addHandler(h);
            h.setFormatter(f);
            LOGGER.log(logLevel, src != null? src + "::" + message : message);
        }catch(IOException exception){
            LOGGER.log(Level.SEVERE, "Error occured in DBSLoggerUtil.", exception);
        }
	}
	
}
