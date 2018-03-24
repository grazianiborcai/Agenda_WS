package br.com.gda.employee.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;

public final class EmpStmtOption<T> implements Cloneable {
	public Connection conn;
	public String schemaName;
	public T recordInfo;
	
	
	
	@SuppressWarnings("unchecked")
	@Override public Object clone()throws CloneNotSupportedException {  
		try {
			EmpStmtOption<T> deepCopy = (EmpStmtOption<T>) super.clone(); 
			deepCopy.recordInfo = (T) recordInfo.getClass().getMethod("clone").invoke(recordInfo);
			return deepCopy;
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new CloneNotSupportedException();
		} 		
	}  
}
