package br.com.gda.business.timeRange.info;

import java.time.LocalTime;
import java.util.List;

import br.com.gda.info.RecordInfo;

public final class TimeRangeInfo extends RecordInfo implements Cloneable {
	public LocalTime beginTime;
	public LocalTime endTime;
	
	
	
	public static TimeRangeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, TimeRangeInfo.class);
	}
	
	
	
	public static List<TimeRangeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, TimeRangeInfo.class);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		TimeRangeInfo deepCopy = (TimeRangeInfo) super.clone();  		
		
		LocalTime cloneTimeValidFrom = null;		
		if (beginTime != null) 
			cloneTimeValidFrom = LocalTime.of(beginTime.getHour(), beginTime.getMinute(), beginTime.getSecond());
		
		
		LocalTime cloneTimeValidTo = null;		
		if (endTime != null) 
			cloneTimeValidTo = LocalTime.of(endTime.getHour(), endTime.getMinute(), endTime.getSecond());
				
		
		deepCopy.beginTime = cloneTimeValidFrom;
		deepCopy.endTime = cloneTimeValidTo;
				
		return deepCopy;	
	}  
}
