package br.com.gda.business.storeLeaveDateSearch.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class StolarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int yearValidFrom;
	public int monthValidFrom;
	public LocalDate dateValidFrom;
	public LocalDate dateValidTo;
	public LocalTime timeValidFrom;
	public LocalTime timeValidTo;
	public String username;
	public String recordMode;
	
	
	public StolarchInfo() {
		super(StolarchInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		yearValidFrom = DefaultValue.number();
		monthValidFrom = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	

	public static StolarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StolarchInfo.class);
	}
	
	
	
	public static List<StolarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StolarchInfo.class);
	}
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		StolarchInfo deepCopy = (StolarchInfo) super.clone();  		
		
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
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		
		if (dateValidFrom != null) {			
			int numDate = Integer.valueOf(dateValidFrom.format(DateTimeFormatter.BASIC_ISO_DATE));
			result = result * 31 + (int) numDate;
		}
		
		if (timeValidFrom != null) {			
			int numTime = Integer.valueOf(timeValidFrom.format(DateTimeFormatter.ofPattern("HHmm")));
			result = result * 31 + (int) numTime;
		}
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StolarchInfo))
			return false;
		
		
		StolarchInfo obj = (StolarchInfo) o;
				
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				isDateEqual(dateValidFrom, obj.dateValidFrom) &&
				isTimeEqual(timeValidFrom, obj.timeValidFrom));
	}
}
