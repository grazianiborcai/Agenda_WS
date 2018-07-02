package br.com.gda.business.employeeWorkTimeConflict.info;

import java.time.LocalTime;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;

public final class EmpCoInfo implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String codTimezone;
	public String codLanguage;
	public String recordMode;
	
	
	public EmpCoInfo() {
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
		this.codEmployee = DefaultValue.number();
		this.codWeekday = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;
	}
	
	
	
	public EmpWTimeInfo toEmpWTimeInfo() {
		EmpWTimeInfo empWTimeInfo = new EmpWTimeInfo();
		empWTimeInfo.codOwner = codOwner;
		empWTimeInfo.codStore = codStore;
		empWTimeInfo.codEmployee = codEmployee;
		empWTimeInfo.codWeekday = codWeekday;
		empWTimeInfo.txtWeekday = txtWeekday;
		empWTimeInfo.beginTime = LocalTime.of(beginTime.getHour(), beginTime.getMinute(), beginTime.getSecond());
		empWTimeInfo.endTime = LocalTime.of(endTime.getHour(), endTime.getMinute(), endTime.getSecond());
		empWTimeInfo.codTimezone = codTimezone;
		empWTimeInfo.codLanguage = codLanguage;
		empWTimeInfo.recordMode = recordMode;
		
		return empWTimeInfo;
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		EmpCoInfo deepCopy = (EmpCoInfo) super.clone();  		
		
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
