package br.com.gda.business.storeLeaveDate.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.RecordInfo;

public final class StoreLDateInfo extends RecordInfo implements Cloneable {
	public long codOwner;
	public long codStore;
	public LocalDate dateValidFrom;
	public LocalDate dateValidTo;
	public LocalTime timeValidFrom;
	public LocalTime timeValidTo;
	public String codTimezone;
	public String description;
	public String recordMode;
	
	
	public StoreLDateInfo() {
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
		this.recordMode = RecordMode.RECORD_OK;
	}
	
	
	
	public static StoreLDateInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoreLDateInfo.class);
	}
	
	
	
	public static List<StoreLDateInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoreLDateInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		StoreLDateInfo deepCopy = (StoreLDateInfo) super.clone();  		
		
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
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StoreLDateInfo))
			return false;
		
		
		StoreLDateInfo obj = (StoreLDateInfo) o;
				
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				isDateEqual(dateValidFrom, obj.dateValidFrom));
	}
}
