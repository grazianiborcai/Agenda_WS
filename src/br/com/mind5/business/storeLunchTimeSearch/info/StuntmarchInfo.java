package br.com.mind5.business.storeLunchTimeSearch.info;

import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class StuntmarchInfo extends InfoRecord implements Cloneable {
	public long codOwner;
	public long codStore;
	public int codWeekday;
	public LocalTime beginTime;
	public LocalTime endTime;
	public String username;
	public String recordMode;
	
	
	public StuntmarchInfo() {
		super();
		
		codOwner = DefaultValue.number();
		codStore = DefaultValue.number();
		codWeekday = DefaultValue.number();
		recordMode = DefaultValue.recordMode();
	}
	
	
	
	public static StuntmarchInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, StuntmarchInfo.class);
	}
	
	
	
	public static List<StuntmarchInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, StuntmarchInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		return (StuntmarchInfo) super.clone(); 
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
		
		
		if (!(o instanceof StuntmarchInfo))
			return false;
		
		
		StuntmarchInfo obj = (StuntmarchInfo) o;		
		return (codOwner 	== obj.codOwner 	&& 
				codStore 	== obj.codStore 	&&
				codWeekday 	== obj.codWeekday);
	}	
}
