package br.com.mind5.business.storeWorkTimeRange.info;

import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StoworgInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String username;
	public String recordMode;
	
	
	public StoworgInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codWeekday = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static StoworgInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StoworgInfo.class);
	}
	
	
	
	public static List<StoworgInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StoworgInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		return super.clone();
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
		
		
		if (!(o instanceof StoworgInfo))
			return false;
		
		
		StoworgInfo obj = (StoworgInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codStore 	== obj.codStore 	&&
				codWeekday 	== obj.codWeekday);
	}	
}
