package br.com.mind5.business.timeRange.info;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoRecord;

public class DateTimeInfo extends InfoRecord implements Cloneable {
	private static boolean BEFORE = true;
	private static boolean AFTER_OR_EQUAL = false;
	
	public LocalTime beginTime;
	public LocalTime endTime;
	public LocalDate date;
	
	
	public DateTimeInfo() {
		super(DateTimeInfo.class);
	}
	
	
	
	public static DateTimeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, DateTimeInfo.class);
	}
	
	
	
	public static List<DateTimeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, DateTimeInfo.class);
	}
	
	
	
	public boolean isBefore(DateTimeInfo toCompare) {
		checkArgument(toCompare);
		
		if (date.isBefore(toCompare.date))
			return BEFORE;
		
		if (date.isAfter(toCompare.date))
			return AFTER_OR_EQUAL;
		
		if (beginTime.isBefore(toCompare.beginTime))
			return BEFORE;
		
		return AFTER_OR_EQUAL;
	}
	
	
	
	private void checkArgument(DateTimeInfo toCheck) {
		if (toCheck == null)
			throw new NullPointerException("toCheck" + SystemMessage.NULL_ARGUMENT);
		
		if (toCheck.beginTime == null)
			throw new NullPointerException("toCheck.beginTime" + SystemMessage.NULL_ARGUMENT);
		
		if (toCheck.endTime == null)
			throw new NullPointerException("toCheck.endTime" + SystemMessage.NULL_ARGUMENT);
		
		if (toCheck.date == null)
			throw new NullPointerException("toCheck.date" + SystemMessage.NULL_ARGUMENT);
		
		if (beginTime == null)
			throw new NullPointerException("beginTime" + SystemMessage.NULL_ARGUMENT);
		
		if (endTime == null)
			throw new NullPointerException("endTime" + SystemMessage.NULL_ARGUMENT);
		
		if (date == null)
			throw new NullPointerException("date" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		DateTimeInfo deepCopy = (DateTimeInfo) super.clone();  
		deepCopy.beginTime = beginTime;
		deepCopy.endTime = endTime;
		deepCopy.date = date;
				
		return deepCopy;	
	}  
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (beginTime != null) {			
			int numTime = Integer.valueOf(beginTime.format(DateTimeFormatter.ofPattern("HHmm")));
			result = result * 31 + numTime;
		}
		
		if (endTime != null) {			
			int numTime = Integer.valueOf(endTime.format(DateTimeFormatter.ofPattern("HHmm")));
			result = result * 31 + numTime;
		}
		
		if (date != null) {			
			int numDate = Integer.valueOf(date.format(DateTimeFormatter.BASIC_ISO_DATE));
			result = result * 31 + numDate;
		}
		
		return result;
	}
	
	
	
	@Override public boolean equals(Object o) {
		if (o == this)
			return true;
		
		
		if (!(o instanceof DateTimeInfo))
			return false;
		
		
		DateTimeInfo obj = (DateTimeInfo) o;	
		return (isTimeEqual(beginTime, obj.beginTime) &&
				isTimeEqual(endTime, obj.endTime)     &&
				isDateEqual(date, obj.date));
	}		
}
