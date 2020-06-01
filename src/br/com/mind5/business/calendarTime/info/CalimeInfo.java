package br.com.mind5.business.calendarTime.info;

import java.time.LocalTime;
import java.util.List;

import br.com.mind5.common.DefaultValue;
import br.com.mind5.info.InfoRecord;

public final class CalimeInfo extends InfoRecord implements Cloneable {
	public LocalTime timeBin;
	public boolean isLocked;
	
	
	public CalimeInfo() {
		super();
		
		timeBin = DefaultValue.object();
		isLocked = DefaultValue.boole();
	}
	
	
	
	public static CalimeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, CalimeInfo.class);
	}
	
	
	
	public static List<CalimeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, CalimeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException {  
		return super.clone();  	
	} 
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (timeBin != null)		
			result = timeBin.hashCode();
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof CalimeInfo))
			return false;
		
		
		CalimeInfo obj = (CalimeInfo) o;		
		return (super.isTimeEqual(timeBin, obj.timeBin));
	}	
}
