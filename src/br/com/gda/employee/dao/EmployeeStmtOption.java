package br.com.gda.employee.dao;

import java.sql.Connection;

import br.com.gda.employee.info.EmployeeWorkingTimeInfo;

public final class EmployeeStmtOption implements Cloneable {
	public Connection conn;
	public String schemaName;
	public EmployeeWorkingTimeInfo workingTime;
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		EmployeeStmtOption deepCopy = (EmployeeStmtOption) super.clone();  
		deepCopy.workingTime = (EmployeeWorkingTimeInfo) workingTime.clone();
		
		return deepCopy;
	}  
}
