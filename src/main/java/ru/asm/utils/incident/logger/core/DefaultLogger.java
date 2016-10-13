package ru.asm.utils.incident.logger.core;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 
 */
public class DefaultLogger extends AbstractLogger{

	static SimpleDateFormat ft =  new SimpleDateFormat ("yyyy-MM-dd'T'HH:mm:ssXXX");//w3c datetime format
	
	public DefaultLogger(ILoggerData<?> data) {
		super(data);
	}
	
	protected void writeData(String message){
	    Package objPackage = this.getClass().getPackage(); 
	    
	    String appname = objPackage.getSpecificationTitle();
	    String appver = objPackage.getSpecificationVersion();
	      
	    data.set("Application", appname+ " v"+appver);
	    data.set("DateTime", ft.format(new Date()));
	    data.set("UserName", System.getProperty("user.name"));
	    data.set("Data", message);
	    data.end();
	}
}
