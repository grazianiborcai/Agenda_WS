package br.com.mind5.business.storeWorkTime.info;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StowotmInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codWeekday;
	public String txtWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String codTimezone;
	public LocalDateTime lastChanged;
	public long lastChangedBy;
	public String username;
	public String recordMode;
	
	
	public StowotmInfo() {
		super(StowotmInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codWeekday = DefaultValue.number();
		lastChangedBy = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static StowotmInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StowotmInfo.class);
	}
	
	
	
	public static List<StowotmInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StowotmInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		StowotmInfo deepCopy = (StowotmInfo) super.clone();  		
		
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
		
		result = result * 31 + (int) (codOwner ^ (codOwner >>> 32));
		result = result * 31 + (int) (codStore ^ (codStore >>> 32));
		result = result * 31 + codWeekday;
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof StowotmInfo))
			return false;
		
		
		StowotmInfo obj = (StowotmInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codStore 	== obj.codStore 	&&
				codWeekday 	== obj.codWeekday);
	}	
}
