package br.com.gda.business.timeRange.info;

import java.time.LocalTime;

public final class TimeRangeInfo implements Cloneable {
	public LocalTime beginTime;
	public LocalTime endTime;
	
	
	
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
