package br.com.gda.business.cartReserve.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.info.InfoRecord;

public final class CarterveInfo extends InfoRecord implements Cloneable {	
	public long codOwner;	
	public long codUser;
	public long codCustomer;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public LocalDate date;
	public LocalTime beginTime;
	public LocalTime endTime;
	public LocalDateTime lastChanged;
	public LocalDateTime timeValidFrom;
	public LocalDateTime timeValidTo;
	public String codLanguage;
	public String username;
	
	
	
	public CarterveInfo() {
		codOwner = DefaultValue.number();	
		codUser = DefaultValue.number();
		codCustomer = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();	
		codLanguage = DefaultValue.language();
	}
	
	
	
	public static CarterveInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CarterveInfo.class);
	}
	
	
	
	public static List<CarterveInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CarterveInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		CarterveInfo deepCopy = (CarterveInfo) super.clone();
		
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
		
		
		if (!(o instanceof CarterveInfo))
			return false;
		
		
		CarterveInfo obj = (CarterveInfo) o;		
		return (codOwner    == obj.codOwner    			&&
				codStore 	== obj.codStore 			&&
				codMat  	== obj.codMat	   			&&
				isDateEqual(date, obj.date)	   			&&
				isTimeEqual(beginTime, obj.beginTime)	&&
				isTimeEqual(endTime, obj.endTime));
	}
}
