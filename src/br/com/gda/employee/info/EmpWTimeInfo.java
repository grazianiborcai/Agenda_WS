package br.com.gda.employee.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.employee.dao.EmpDbTable;
import br.com.gda.employee.dao.EmpDbTableColumn;
import br.com.gda.sql.SqlColumn;

public class EmpWTimeInfo implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public int weekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String recordMode;
	
	
	public EmpWTimeInfo() {
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
		this.codEmployee = DefaultValue.number();
		this.weekday = DefaultValue.number();
	}
	
	
	
	public List<SqlColumn> toColumns() {
		Hashtable<String, SqlColumn> columns;
		columns = EmpDbTableColumn.getTableColumnsAsHashTable(EmpDbTable.EMPLOYEE_WORKING_TIME_TABLE);
		
		List<SqlColumn> resultColumns = new ArrayList<>();
		SqlColumn eachColumn = columns.get("cod_owner");
		//eachColumn.columnValue = codOwner;
		return resultColumns;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		EmpWTimeInfo deepCopy = (EmpWTimeInfo) super.clone();  		
		
		LocalTime cloneBeginTime = null;		
		if (beginTime != null) 
			cloneBeginTime = LocalTime.of(beginTime.getHour(), beginTime.getMinute(), beginTime.getSecond());
		
		LocalTime cloneEndTime = null;		
		if (endTime != null) 
			cloneEndTime = LocalTime.of(endTime.getHour(), endTime.getMinute(), endTime.getSecond());
				
		
		deepCopy.beginTime = cloneBeginTime;
		deepCopy.endTime = cloneEndTime;
				
		return deepCopy;	
	}  
}