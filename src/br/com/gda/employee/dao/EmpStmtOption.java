package br.com.gda.employee.dao;

import java.sql.Connection;

import br.com.gda.employee.info.EmpWtimeInfo;

public final class EmpStmtOption implements Cloneable {
	public Connection conn;
	public String schemaName;
	public EmpWtimeInfo workingTime;
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		EmpStmtOption deepCopy = (EmpStmtOption) super.clone();  
		deepCopy.workingTime = (EmpWtimeInfo) workingTime.clone();
		
		return deepCopy;
	}  
}
