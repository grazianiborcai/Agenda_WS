package br.com.gda.business.storeWorkTime.info;

import java.time.LocalTime;
import java.util.List;

import br.com.gda.common.DefaultValue;
import br.com.gda.common.Language;
import br.com.gda.helper.RecordMode;
import br.com.gda.info.RecordInfo;

public final class StoreWTimeInfo extends RecordInfo implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String codTimezone;
	public String codLanguage;
	public String recordMode;
	
	
	public StoreWTimeInfo() {
		this.codOwner = DefaultValue.number();
		this.codStore = DefaultValue.number();
		this.codWeekday = DefaultValue.number();
		this.codLanguage = Language.getDefaultLanguage();
		this.recordMode = RecordMode.RECORD_OK;
	}
	
	
	
	public static StoreWTimeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoreWTimeInfo.class);
	}
	
	
	
	public static List<StoreWTimeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoreWTimeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		StoreWTimeInfo deepCopy = (StoreWTimeInfo) super.clone();  		
		
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
		result = result * codWeekday;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StoreWTimeInfo))
			return false;
		
		
		StoreWTimeInfo obj = (StoreWTimeInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codStore 	== obj.codStore 	&&
				codWeekday 	== obj.codWeekday);
	}	
}
