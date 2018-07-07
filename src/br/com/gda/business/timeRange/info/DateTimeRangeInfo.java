package br.com.gda.business.timeRange.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.gda.info.RecordInfo;

public final class DateTimeRangeInfo extends RecordInfo implements Cloneable {
	public LocalDate dateValidFrom;
	public LocalDate dateValidTo;
	public LocalTime timeValidFrom;
	public LocalTime timeValidTo;
	
	
	
	public static DateTimeRangeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, DateTimeRangeInfo.class);
	}
	
	
	
	public static List<DateTimeRangeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, DateTimeRangeInfo.class);
	}	
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		DateTimeRangeInfo deepCopy = (DateTimeRangeInfo) super.clone();  		
		
		LocalTime cloneTimeValidFrom = null;		
		if (timeValidFrom != null) 
			cloneTimeValidFrom = LocalTime.of(timeValidFrom.getHour(), timeValidFrom.getMinute(), timeValidFrom.getSecond());
		
		
		LocalTime cloneTimeValidTo = null;		
		if (timeValidTo != null) 
			cloneTimeValidTo = LocalTime.of(timeValidTo.getHour(), timeValidTo.getMinute(), timeValidTo.getSecond());
		
		
		LocalDate cloneDateValidFrom = null;	
		if (dateValidFrom != null) 
			cloneDateValidFrom = LocalDate.of(dateValidFrom.getYear(), dateValidFrom.getMonth(), dateValidFrom.getDayOfMonth());
		
		
		LocalDate cloneDateValidTo = null;	
		if (dateValidTo != null) 
			cloneDateValidTo = LocalDate.of(dateValidTo.getYear(), dateValidTo.getMonth(), dateValidTo.getDayOfMonth());
				
		
		deepCopy.timeValidFrom = cloneTimeValidFrom;
		deepCopy.timeValidTo = cloneTimeValidTo;
		deepCopy.dateValidFrom = cloneDateValidFrom;
		deepCopy.dateValidTo = cloneDateValidTo;
				
		return deepCopy;	
	}  
}
