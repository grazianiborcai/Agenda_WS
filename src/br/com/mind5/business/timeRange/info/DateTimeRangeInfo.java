package br.com.mind5.business.timeRange.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.mind5.info.InfoRecord;

public final class DateTimeRangeInfo extends InfoRecord implements Cloneable {
	public LocalDate dateValidFrom;
	public LocalDate dateValidTo;
	public LocalTime timeValidFrom;
	public LocalTime timeValidTo;
	
	
	public DateTimeRangeInfo() {
		super(DateTimeRangeInfo.class);
	}
	
	
	
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
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (dateValidFrom != null) {			
			int numDate = Integer.valueOf(dateValidFrom.format(DateTimeFormatter.BASIC_ISO_DATE));
			result = result * 31 + numDate;
		}
		
		if (timeValidFrom != null) {			
			int numTime = Integer.valueOf(timeValidFrom.format(DateTimeFormatter.ofPattern("HHmm")));
			result = result * 31 + numTime;
		}
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof DateTimeRangeInfo))
			return false;
		
		
		DateTimeRangeInfo obj = (DateTimeRangeInfo) o;
		
		return (isDateEqual(dateValidFrom, obj.dateValidFrom) && 
				isTimeEqual(timeValidFrom, obj.timeValidFrom));
	}	
}
