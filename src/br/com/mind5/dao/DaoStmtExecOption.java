package br.com.mind5.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

public final class DaoStmtExecOption<T> implements Cloneable {
	public Connection conn;
	public T recordInfo;
	public String schemaName;
		
	
	@SuppressWarnings("unchecked")
	@Override public Object clone()throws CloneNotSupportedException {  
		try {
			DaoStmtExecOption<T> deepCopy = (DaoStmtExecOption<T>) super.clone(); 
			deepCopy.recordInfo = (T) recordInfo.getClass().getMethod("clone").invoke(recordInfo);
			
			return deepCopy;
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new CloneNotSupportedException();
		} 		
	}  
}
