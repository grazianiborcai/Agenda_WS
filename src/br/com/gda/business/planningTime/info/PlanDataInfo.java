package br.com.gda.business.planningTime.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.info.RecordInfo;

public final class PlanDataInfo extends RecordInfo implements Cloneable {
	public long codOwner;	
	public int codWeekday;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public String codLanguage;
	public LocalDate date;
	public LocalTime beginTime;
	public LocalTime endTime;	
	
	
	public PlanDataInfo() {
		codOwner = DefaultValue.number();
		codWeekday = DefaultValue.number();
		codMat = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codLanguage = Language.getDefaultLanguage();
	}
	
	
	
	public static PlanDataInfo copyFrom (Object sourceObj) {
		return copyFrom(sourceObj, PlanDataInfo.class);
	}
	
	
	
	public static List<PlanDataInfo> copyFrom (List<?> sourceObjs) {
		return copyFrom(sourceObjs, PlanDataInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		PlanDataInfo deepCopy = (PlanDataInfo) super.clone();  		
		
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
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * (int) (codStore 	 ^ (codStore 	>>> 32));
		result = result * (int) (codMat 	 ^ (codMat 		>>> 32));
		result = result * codWeekday;
		
		if (date != null) {			
			int numDate = Integer.valueOf(date.format(DateTimeFormatter.BASIC_ISO_DATE));
			result = result * (int) numDate;
		}
		
		if (beginTime != null) {			
			int numTime = Integer.valueOf(beginTime.format(DateTimeFormatter.ofPattern("HHmm")));
			result = result * (int) numTime;
		}
		
		if (endTime != null) {			
			int numTime = Integer.valueOf(endTime.format(DateTimeFormatter.ofPattern("HHmm")));
			result = result * (int) numTime;
		}
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PlanDataInfo))
			return false;
		
		
		PlanDataInfo obj = (PlanDataInfo) o;		
		return (codOwner 	== obj.codOwner 		  && 
				codEmployee == obj.codEmployee 		  &&
				codStore 	== obj.codStore 		  && 
				codMat 		== obj.codMat 			  && 
				codWeekday 	== obj.codWeekday  		  &&
				isDateEqual(date, obj.date)     	  &&
				isTimeEqual(beginTime, obj.beginTime) &&
				isTimeEqual(endTime, obj.endTime));
	}
}
