package br.com.mind5.business.storeWorkTimeSnapshot.info;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StowotmapInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String codTimezone;
	public long codSnapshot;
	public LocalDateTime createdOn;
	public long createdBy;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String recordMode;
	
	
	public StowotmapInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codWeekday = DefaultValue.number();
		codSnapshot = DefaultValue.number();
		createdBy = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
		beginTime = DefaultValue.object();
		endTime = DefaultValue.object();
		createdOn = DefaultValue.object();
		lastChanged = DefaultValue.object();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static StowotmapInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StowotmapInfo.class);
	}
	
	
	
	public static List<StowotmapInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StowotmapInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		StowotmapInfo deepCopy = (StowotmapInfo) super.clone();  		
		
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
		
		result = result * 31 + (int) (codSnapshot ^ (codSnapshot >>> 32));
		result = result * 31 + (int) (codOwner    ^ (codOwner    >>> 32));
		result = result * 31 + (int) (codStore    ^ (codStore    >>> 32));
		result = result * 31 + codWeekday;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StowotmapInfo))
			return false;
		
		
		StowotmapInfo obj = (StowotmapInfo) o;		
		return (codSnapshot == obj.codSnapshot 	&& 
				codOwner 	== obj.codOwner 	&& 
				codStore 	== obj.codStore 	&&
				codWeekday 	== obj.codWeekday);
	}	
}
