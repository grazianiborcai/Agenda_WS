package br.com.gda.model.decisionTree;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public final class DeciTreeOption<T> implements Cloneable {
	public List<T> recordInfos;
	public Connection conn;
	public String schemaName;
	
	
	
	@SuppressWarnings("unchecked")
	@Override public Object clone()throws CloneNotSupportedException {  
		try {
			DeciTreeOption<T> deepCopy = (DeciTreeOption<T>) super.clone(); 
			deepCopy.recordInfos = new ArrayList<>();
			
			for (T eachRecord : recordInfos) {
				T clonedInfo = (T) eachRecord.getClass().getMethod("clone").invoke(eachRecord);
				deepCopy.recordInfos.add(clonedInfo);
			}
			
			return deepCopy;
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new CloneNotSupportedException();
		} 		
	}  
}
