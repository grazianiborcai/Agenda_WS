package br.com.gda.business.age.info;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.gda.business.timeRange.info.DateTimeInfo;
import br.com.gda.common.DefaultValue;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoRecord;

public final class AgeInfo extends InfoRecord implements Cloneable {
	private static final int defaultFactor = 15;
	private final boolean AGED = true;
	private final boolean NEGATIVE = false;
	
	private LocalTime time;
	private LocalDate date;
	
	
	
	public AgeInfo() {
		this(defaultFactor);
	}



	public AgeInfo(int minuteToFade) {
		checkArgument(minuteToFade);
		
		LocalDateTime dateTime = DefaultValue.localDateTimeNow();
		dateTime = dateTime.minusMinutes(minuteToFade);
		date = dateTime.toLocalDate();
		time = dateTime.toLocalTime();
	}
	
	
	
	private void checkArgument(int minuteToFade) {
		if (minuteToFade <= 0)
			throw new IllegalArgumentException("minuteToFade" + SystemMessage.POSITIVE_NUM_EXPECTED);
	}
	
	
	
	public static AgeInfo copyFrom(Object sourceObj) {
		return copyFrom(sourceObj, AgeInfo.class);
	}
	
	
	
	public static List<AgeInfo> copyFrom(List<?> sourceObjs) {
		return copyFrom(sourceObjs, AgeInfo.class);
	}
	
	
	
	public boolean isAged(Object toCompare) {
		DateTimeInfo timeToCompare = DateTimeInfo.copyFrom(toCompare);
		return isAged(timeToCompare);
	}
	
	
	
	public boolean isAged(DateTimeInfo toCompare) {
		checkArgument(toCompare);
		
		if (date.isAfter(toCompare.date))
			return AGED;
		
		if (date.isBefore(toCompare.date))
			return NEGATIVE;
		
		if (time.isAfter(toCompare.beginTime))
			return AGED;
		
		return NEGATIVE;
	}
	
	
	
	private void checkArgument(DateTimeInfo toCheck) {
		if (toCheck == null)
			throw new NullPointerException("toCheck" + SystemMessage.NULL_ARGUMENT);
		
		if (toCheck.beginTime == null)
			throw new NullPointerException("toCheck.beginTime" + SystemMessage.NULL_ARGUMENT);
		
		if (toCheck.date == null)
			throw new NullPointerException("toCheck.date" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	@Override public Object clone()throws CloneNotSupportedException{  
		AgeInfo deepCopy = (AgeInfo) super.clone();  
		deepCopy.time = time;
		deepCopy.date = date;
				
		return deepCopy;	
	}  
	
	
	
	@Override public int hashCode() {
		int result = 17;
		
		if (time != null) {			
			int numTime = Integer.valueOf(time.format(DateTimeFormatter.ofPattern("HHmm")));
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
		
		if (!(o instanceof AgeInfo))
			return false;		
		
		AgeInfo obj = (AgeInfo) o;	
		return (isTimeEqual(time, obj.time) &&
				isDateEqual(date, obj.date));
	}		
}
