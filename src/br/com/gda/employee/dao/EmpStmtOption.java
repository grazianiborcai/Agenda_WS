package br.com.gda.employee.dao;

import java.sql.Connection;

import br.com.gda.employee.info.EmpWorkTimeInfo;

public final class EmpStmtOption implements Cloneable {
	public Connection conn;
	public String schemaName;
	public EmpWorkTimeInfo workingTime;
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		EmpStmtOption deepCopy = (EmpStmtOption) super.clone();  
		deepCopy.workingTime = (EmpWorkTimeInfo) workingTime.clone();
		
		return deepCopy;
	}  
}
