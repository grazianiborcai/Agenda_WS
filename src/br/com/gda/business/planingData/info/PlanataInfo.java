package br.com.gda.business.planingData.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class PlanataInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public int codWeekday;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public String codLanguage;
	public LocalDate date;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String username;
	public String recordMode;
	
	
	public PlanataInfo() {
		codOwner = DefaultValue.number();
		codWeekday = DefaultValue.number();
		codMat = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codLanguage = DefaultValue.language();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static PlanataInfo copyFrom (Object sourceObj) {
		return copyFrom(sourceObj, PlanataInfo.class);
	}
	
	
	
	public static List<PlanataInfo> copyFrom (List<?> sourceObjs) {
		return copyFrom(sourceObjs, PlanataInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		PlanataInfo deepCopy = (PlanataInfo) super.clone();  		
		
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
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codMat 	  ^ (codMat 	 >>> 32));
		result = result * 31 + codWeekday;
		
		if (date != null) {			
			int numDate = Integer.valueOf(date.format(DateTimeFormatter.BASIC_ISO_DATE));
			result = result * 31 + numDate;
		}
		
		if (beginTime != null) {			
			int numTime = Integer.valueOf(beginTime.format(DateTimeFormatter.ofPattern("HHmm")));
			result = result * 31 + numTime;
		}
		
		if (endTime != null) {			
			int numTime = Integer.valueOf(endTime.format(DateTimeFormatter.ofPattern("HHmm")));
			result = result * 31 + numTime;
		}
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof PlanataInfo))
			return false;
		
		
		PlanataInfo obj = (PlanataInfo) o;		
		
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
