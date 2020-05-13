package br.com.mind5.business.scheduleReserve.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class SchederveInfo extends InfoRecord implements Cloneable {	
	public long codSchedule;
	public long codOwner;	
	public long codUser;
	public long codStore;
	public long codEmployee;
	public long codMat;
	public LocalDate date;
	public LocalTime beginTime;
	public LocalTime endTime;
	public LocalDateTime lastChanged;
	public String username;
	
	
	public SchederveInfo() {
		super();
		
		codSchedule = DefaultValue.number();
		codOwner = DefaultValue.number();	
		codUser = DefaultValue.number();
		codStore = DefaultValue.number();
		codEmployee = DefaultValue.number();
		codMat = DefaultValue.number();
	}
	
	
	
	public static SchederveInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, SchederveInfo.class);
	}
	
	
	
	public static List<SchederveInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, SchederveInfo.class);
	}
	
	
	
	@Override public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codUser     ^ (codUser     >>> 32));
		result = result * 31 + (int) (codStore 	  ^ (codStore 	 >>> 32));
		result = result * 31 + (int) (codMat  	  ^ (codMat  	 >>> 32));
		result = result * 31 + (int) (codEmployee ^ (codEmployee >>> 32));
		
		if (date != null) 
			result = result * 31 + date.hashCode();
		
		if (beginTime != null)
			result = result * 31 + beginTime.hashCode();
		
		if (endTime != null)
			result = result * 31 + endTime.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof SchederveInfo))
			return false;
		
		
		SchederveInfo obj = (SchederveInfo) o;		
		return (codOwner    == obj.codOwner    			&&
				codUser		== obj.codUser 				&&
				codStore 	== obj.codStore 			&&
				codMat  	== obj.codMat	   			&&
				codEmployee == obj.codEmployee	   		&&
				isDateEqual(date, obj.date)	   			&&
				isTimeEqual(beginTime, obj.beginTime)	&&
				isTimeEqual(endTime, obj.endTime));
	}
}
