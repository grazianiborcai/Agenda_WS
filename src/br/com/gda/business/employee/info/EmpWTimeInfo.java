package br.com.gda.business.employee.info;

import java.time.LocalTime;
import br.com.gda.common.DefaultValue;
import br.com.gda.helper.RecordMode;

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
		this.recordMode = RecordMode.RECORD_OK;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
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