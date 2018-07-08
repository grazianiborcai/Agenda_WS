package br.com.gda.business.planningTime.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public final class PlanTimeInfo extends RecordInfo implements Cloneable {
	public long codOwner;
	public LocalDate date;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;	
	public List<Long> materials;
	public List<Long> stores;
	public List<Long> employees;	
	public String codLanguage;
	
	
	public PlanTimeInfo() {
		codOwner = DefaultValue.number();
		codWeekday = DefaultValue.number();
		codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static PlanTimeInfo copyFrom (Object sourceObj) {
		return copyFrom(sourceObj, PlanTimeInfo.class);
	}
	
	
	
	public static List<PlanTimeInfo> copyFrom (List<?> sourceObjs) {
		return copyFrom(sourceObjs, PlanTimeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		PlanTimeInfo deepCopy = (PlanTimeInfo) super.clone();  		
		
		LocalTime cloneBeginTime = null;		
		if (beginTime != null) 
			cloneBeginTime = LocalTime.of(beginTime.getHour(), beginTime.getMinute(), beginTime.getSecond());
		
		LocalTime cloneEndTime = null;		
		if (endTime != null) 
			cloneEndTime = LocalTime.of(endTime.getHour(), endTime.getMinute(), endTime.getSecond());
		
		LocalDate cloneDate = null;	
		if (date != null) 
			cloneDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());				
		
		deepCopy.date = cloneDate;
		deepCopy.beginTime = cloneBeginTime;
		deepCopy.endTime = cloneEndTime;
				
		return deepCopy;	
	}  
}
