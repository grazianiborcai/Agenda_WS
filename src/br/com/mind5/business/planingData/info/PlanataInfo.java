package br.com.mind5.business.planingData.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class PlanataInfo extends InfoRecord implements Cloneable, Comparable<PlanataInfo> {
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
	public double price;
	public String codCurr;
	public String txtCurr;
	public String username;
	public String recordMode;
	
	
	public PlanataInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codWeekday = DefaultValue.number();
		codMat = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codDaypart = DefaultValue.number();
		codMoonPhase = DefaultValue.number();
		price = DefaultValue.number();
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
	
	
	
	@Override public int compareTo(PlanataInfo arg0) {
		super.checkCompareToArgument(arg0);
		
		int result = compareToCodOwner(arg0);		
		if (result != 0) return result;
		
		result = compareToDate(arg0);		
		if (result != 0) return result;
		
		result = compareToBeginTime(arg0);		
		if (result != 0) return result;
		
		result = compareToCodStore(arg0);		
		if (result != 0) return result;
		
		result = compareToCodMat(arg0);		
		if (result != 0) return result;

		result = compareToCodEmployee(arg0);		
		if (result != 0) return result;
		
		return 0;
	}
	
	
	
	private int compareToCodOwner(PlanataInfo arg0) {
		if (codOwner > arg0.codOwner) 
			return  1;		
		
		if (codOwner < arg0.codOwner) 
			return -1;
		
		return 0;
	}
	
	
	
	private int compareToDate(PlanataInfo arg0) {
		if (date == null & arg0.date == null)
			return 0;
		
		if (date != null & arg0.date == null)
			return 1;
		
		if (date == null & arg0.date != null)
			return -1;
		
		if (date.isAfter(arg0.date))
			return 1;
		
		if (date.isBefore(arg0.date))
			return -1;
		
		return 0;
	}
	
	
	
	private int compareToBeginTime(PlanataInfo arg0) {
		if (beginTime == null & arg0.beginTime == null)
			return 0;
		
		if (beginTime != null & arg0.beginTime == null)
			return 1;
		
		if (beginTime == null & arg0.beginTime != null)
			return -1;
		
		if (beginTime.isAfter(arg0.beginTime))
			return 1;
		
		if (beginTime.isBefore(arg0.beginTime))
			return -1;
		
		return 0;
	}
	
	
	
	private int compareToCodStore(PlanataInfo arg0) {
		if (codStore > arg0.codStore) 
			return  1;		
		
		if (codStore < arg0.codStore) 
			return -1;
		
		return 0;
	}
	
	
	
	private int compareToCodMat(PlanataInfo arg0) {
		if (codMat > arg0.codMat) 
			return  1;		
		
		if (codMat < arg0.codMat) 
			return -1;
		
		return 0;
	}	
	
	
	
	private int compareToCodEmployee(PlanataInfo arg0) {
		if (codEmployee > arg0.codEmployee) 
			return  1;		
		
		if (codEmployee < arg0.codEmployee) 
			return -1;
		
		return 0;
	}
}
