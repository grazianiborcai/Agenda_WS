package br.com.gda.business.employeeWorkTime.info;

import java.time.LocalTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.RecordInfo;

public class EmpWTimeInfo extends RecordInfo implements Cloneable {
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
	
	
	public EmpWTimeInfo() {
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
		this.codEmployee = DefaultValue.number();
		this.codWeekday = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;
	}
	
	
	
	public static EmpWTimeInfo copyFrom (Object sourceObj) {
		return copyFrom(sourceObj, EmpWTimeInfo.class);
	}
	
	
	
	public static List<EmpWTimeInfo> copyFrom (List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmpWTimeInfo.class);
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