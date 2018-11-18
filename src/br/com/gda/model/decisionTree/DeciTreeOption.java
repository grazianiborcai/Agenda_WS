package br.com.gda.model.decisionTree;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class DeciTreeOption<T> implements Cloneable {
	public List<T> recordInfos;
	public Connection conn;
	public String schemaName;
	
	
	
	@SuppressWarnings("unchecked")
	@Override public Object clone()throws CloneNotSupportedException {  
		try {
			DeciTreeOption<T> deepCopy = (DeciTreeOption<T>) super.clone(); 
			
			if (recordInfos == null)
				return deepCopy;
				
			deepCopy.recordInfos = new ArrayList<>();
			
			for (T eachRecord : recordInfos) {
				T clonedInfo = (T) eachRecord.getClass().getMethod("clone").invoke(eachRecord);
				deepCopy.recordInfos.add(clonedInfo);
			}
			
			return deepCopy;
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			logException(e);
			throw new CloneNotSupportedException();
		} 		
	}  
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
