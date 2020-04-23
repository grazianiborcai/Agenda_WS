package br.com.mind5.business.storeLeaveDate.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StolateInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int yearValidFrom;
	public int monthValidFrom;
	public String txtMonthValidFrom;
	public LocalDateTime validFrom;
	public LocalDate dateValidFrom;
	public LocalDateTime validTo;
	public LocalDate dateValidTo;
	public LocalTime timeValidFrom;
	public LocalTime timeValidTo;
	public String codTimezone;
	public String txtTimezone;
	public String description;
	public LocalDateTime createdOn;
	public long createdBy;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String recordMode;
	
	
	public StolateInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		yearValidFrom = DefaultValue.number();
		monthValidFrom = DefaultValue.number();
		createdBy = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	

	public static StolateInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StolateInfo.class);
	}
	
	
	
	public static List<StolateInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StolateInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		return super.clone();  	
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
		
		
		if (!(o instanceof StolateInfo))
			return false;
		
		
		StolateInfo obj = (StolateInfo) o;
				
		return (codOwner == obj.codOwner && 
				codStore == obj.codStore &&
				isDateEqual(dateValidFrom, obj.dateValidFrom) &&
				isTimeEqual(timeValidFrom, obj.timeValidFrom));
	}
}
