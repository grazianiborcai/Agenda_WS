package br.com.mind5.business.storeWorkTimeSearch.info;

import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StowotarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String username;
	public String recordMode;
	
	
	public StowotarchInfo() {
		super(StowotarchInfo.class);
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codWeekday = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static StowotarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StowotarchInfo.class);
	}
	
	
	
	public static List<StowotarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StowotarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		return (StowotarchInfo) super.clone(); 
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
		
		
		if (!(o instanceof StowotarchInfo))
			return false;
		
		
		StowotarchInfo obj = (StowotarchInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codStore 	== obj.codStore 	&&
				codWeekday 	== obj.codWeekday);
	}	
}
