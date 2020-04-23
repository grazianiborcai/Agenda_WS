package br.com.mind5.business.employeeLeaveDate.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class EmplateInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public LocalDateTime validFrom;
	public LocalDate dateValidFrom;
	public LocalDateTime validTo;
	public LocalDate dateValidTo;
	public LocalTime timeValidFrom;
	public LocalTime timeValidTo;
	public String codTimezone;
	public String txtTimezone;
	public String description;
	public String recordMode;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public LocalDateTime createdOn;
	public long createdBy;
	public String username;
	
	
	public EmplateInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
		lastChangedBy = DefaultValue.number();
		createdBy = DefaultValue.number();
	}
	
	

	public static EmplateInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmplateInfo.class);
	}
	
	
	
	public static List<EmplateInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmplateInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
	}  
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		
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
		
		
		if (!(o instanceof EmplateInfo))
			return false;
		
		
		EmplateInfo obj = (EmplateInfo) o;
		
		return (codOwner    == obj.codOwner 	&& 
				codStore    == obj.codStore 	&&
				codEmployee == obj.codEmployee 	&&
				isDateEqual(dateValidFrom, obj.dateValidFrom) &&
				isTimeEqual(timeValidFrom, obj.timeValidFrom));
	}
}
