package br.com.mind5.business.employeeLeaveDateRange.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class EmplargInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public LocalDateTime validFrom;
	public LocalDateTime validTo;
	public LocalDate dateValidFrom;
	public LocalDate dateValidTo;
	public LocalTime timeValidFrom;
	public LocalTime timeValidTo;
	public String recordMode;
	public String username;
	
	
	public EmplargInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	

	public static EmplargInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, EmplargInfo.class);
	}
	
	
	
	public static List<EmplargInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, EmplargInfo.class);
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
		
		
		if (!(o instanceof EmplargInfo))
			return false;
		
		
		EmplargInfo obj = (EmplargInfo) o;
		
		return (codOwner    == obj.codOwner 	&& 
				codStore    == obj.codStore 	&&
				codEmployee == obj.codEmployee 	&&
				isDateEqual(dateValidFrom, obj.dateValidFrom) &&
				isTimeEqual(timeValidFrom, obj.timeValidFrom));
	}
}
