package br.com.gda.employee.info;

import java.time.LocalTime;

public class EmployeeWorkingTimeInfo implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public int weekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String recordMode;
	
	
	public EmployeeWorkingTimeInfo() {
		this.codOwner = -1;
		this.codStore = -1;
		this.codEmployee = -1;
		this.weekday = -1;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		EmployeeWorkingTimeInfo deepCopy = (EmployeeWorkingTimeInfo) super.clone();  		
		
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