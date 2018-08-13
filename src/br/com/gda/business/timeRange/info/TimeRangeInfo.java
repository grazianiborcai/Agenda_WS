package br.com.gda.business.timeRange.info;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.gda.info.InfoRecord;

public final class TimeRangeInfo extends InfoRecord implements Cloneable {
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
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (beginTime != null) {			
			int numTime = Integer.valueOf(beginTime.format(DateTimeFormatter.ofPattern("HHmm")));
			result = result * 31 + numTime;
		}
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof TimeRangeInfo))
			return false;
		
		
		TimeRangeInfo obj = (TimeRangeInfo) o;	
		return (isTimeEqual(beginTime, obj.beginTime));
	}		
}
