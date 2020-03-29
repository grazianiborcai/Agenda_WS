package br.com.mind5.business.planingData.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PlanataInfo extends InfoRecord implements Cloneable {
	public long codOwner;	
	public int codWeekday;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public LocalDate date;
	public LocalTime beginTime;
	public LocalTime endTime;
	public int codDaypart;
	public int codMoonPhase;
	public String username;
	public String recordMode;
	
	
	public PlanataInfo() {
		super(PlanataInfo.class);
		
		codOwner = DefaultValue.number();
		codWeekday = DefaultValue.number();
		codMat = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codDaypart = DefaultValue.number();
		codMoonPhase = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static PlanataInfo copyFrom (Object sourceObj) {
		return copyFrom(sourceObj, PlanataInfo.class);
	}
	
	
	
	public static List<PlanataInfo> copyFrom (List<?> sourceObjs) {
		return copyFrom(sourceObjs, PlanataInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		return super.clone();
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
