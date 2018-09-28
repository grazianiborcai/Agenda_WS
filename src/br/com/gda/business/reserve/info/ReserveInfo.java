package br.com.gda.business.reserve.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class ReserveInfo extends InfoRecord implements Cloneable {
	private long TIME_SPAN = 15;
	
	public long codOwner;	
	public long codCustomer;
	public int itemNumber;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public LocalDate date;
	public LocalTime beginTime;
	public LocalTime endTime;
	public LocalDateTime lastChanged;
	public LocalDateTime timeValidFrom;
	public LocalDateTime timeValidTo;
	
	
	
	public ReserveInfo() {
		codOwner = DefaultValue.number();	
		codCustomer = DefaultValue.number();
		itemNumber = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();	
		computeValidTimePast();
	}
	
	
	
	private void computeValidTimePast() {		
		timeValidTo = DefaultValue.dateTimeNow();
		timeValidFrom = timeValidTo.minusMinutes(TIME_SPAN);
	}
	
	
	
	public void computeValidTime() {
		timeValidFrom = lastChanged;
		
		if (timeValidFrom == null)
			timeValidFrom = DefaultValue.dateTimeNow();		
		
		timeValidTo = timeValidFrom.plusMinutes(TIME_SPAN);
	}
	
	
	
	public static ReserveInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, ReserveInfo.class);
	}
	
	
	
	public static List<ReserveInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, ReserveInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		ReserveInfo deepCopy = (ReserveInfo) super.clone();
		
		deepCopy.date = date;
		deepCopy.beginTime = beginTime;
		deepCopy.endTime = endTime;
		deepCopy.lastChanged = lastChanged;
		deepCopy.timeValidFrom = timeValidFrom;
		deepCopy.timeValidTo = timeValidTo;
		
		return deepCopy;
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codMat  	  ^ (codMat  	 >>> 32));
		
		if (date != null) {			
			int numDate = Integer.valueOf(date.format(DateTimeFormatter.BASIC_ISO_DATE));
			result = result * 31 + numDate;
		}
		
		if (beginTime != null) {			
			int numDate = Integer.valueOf(beginTime.format(DateTimeFormatter.BASIC_ISO_DATE));
			result = result * 31 + numDate;
		}
		
		if (endTime != null) {			
			int numDate = Integer.valueOf(endTime.format(DateTimeFormatter.BASIC_ISO_DATE));
			result = result * 31 + numDate;
		}
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof ReserveInfo))
			return false;
		
		
		ReserveInfo obj = (ReserveInfo) o;		
		return (codOwner    == obj.codOwner    			&&
				codStore 	== obj.codStore 			&&
				codMat  	== obj.codMat	   			&&
				isDateEqual(date, obj.date)	   			&&
				isTimeEqual(beginTime, obj.beginTime)	&&
				isTimeEqual(endTime, obj.endTime));
	}
}
