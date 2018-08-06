package br.com.gda.business.storeWorkTimeConflict.info;

import java.time.LocalTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.RecordInfo;

public final class StoreCoInfo extends RecordInfo implements Cloneable {
	public long codOwner;
	public long codStore;
	public long codEmployee;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String codTimezone;
	public String codLanguage;
	public String recordMode;	
	
	
	public StoreCoInfo() {
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
		this.codEmployee = DefaultValue.number();
		this.codWeekday = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;
	}
	
	
	
	public static StoreCoInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoreCoInfo.class);
	}
	
	
	
	public static List<StoreCoInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoreCoInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		StoreCoInfo deepCopy = (StoreCoInfo) super.clone();  		
		
		LocalTime cloneBeginTime = null;		
		if (beginTime != null) 
			cloneBeginTime = LocalTime.of(beginTime.getHour(), beginTime.getMinute(), beginTime.getSecond());
		
		LocalTime cloneEndTime = null;		
		if (endTime != null) 
			cloneEndTime = LocalTime.of(endTime.getHour(), endTime.getMinute(), endTime.getSecond());
				
		
		deepCopy.beginTime = cloneBeginTime;
		deepCopy.endTime = cloneEndTime;
				
		return deepCopy;	
	} 
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		result = result * (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * (int) (codStore    ^ (codStore    >>> 32));
		result = result * (int) (codEmployee ^ (codEmployee >>> 32));
		result = result * (int) (codWeekday);
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StoreCoInfo))
			return false;
		
		
		StoreCoInfo obj = (StoreCoInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codStore 	== obj.codStore 	&&
				codEmployee == obj.codEmployee 	&&
				codWeekday 	== obj.codWeekday);
	}
}
