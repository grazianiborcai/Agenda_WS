package br.com.mind5.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class TimeAge {
	private static final int defaultOffset = 15;	
	private final boolean AGED = true;
	private final boolean NOT_AGED = false;	
	private int offset;
	
	
	public TimeAge() {
		this(defaultOffset);
	}



	public TimeAge(int minuteToFade) {
		checkArgument(minuteToFade);
		offset = minuteToFade;
	}
	
	
	
	public boolean isAged(LocalDate dateToCompare, LocalTime timeToCompare) {
		checkArgument(dateToCompare, timeToCompare);
		
		LocalDateTime toCompare = LocalDateTime.of(dateToCompare, timeToCompare);		
		return isAged(toCompare);
	}
	
	
	
	public boolean isAged(LocalDateTime toCompare) {
		checkArgument(toCompare);		
		LocalDateTime validTimeFrom = getNowMinusOffset();
		
		if (toCompare.isBefore(validTimeFrom))
			return AGED;
		
		return NOT_AGED;
	}	
	
	
	
	public LocalDateTime getNowMinusOffset() {
		return DefaultValue.localDateTimeNow().minusMinutes(offset);
	}
	
	
	
	public LocalDateTime getDateTimePlusOffset(LocalDateTime baseTime) {
		checkArgument(baseTime);
		
		return baseTime.plusMinutes(offset);
	}
	
	
	
	private void checkArgument(int minuteToFade) {
		if (minuteToFade <= 0)
			throw new IllegalArgumentException("minuteToFade" + SystemMessage.POSITIVE_NUM_EXPECTED);
	}
	
	
	
	private void checkArgument(LocalDate dateToCompare, LocalTime timeToCompare) {
		if (dateToCompare == null)
			throw new NullPointerException("dateToCompare" + SystemMessage.NULL_ARGUMENT);
		
		if (timeToCompare == null)
			throw new NullPointerException("timeToCompare" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private void checkArgument(LocalDateTime toCompare) {
		if (toCompare == null)
			throw new NullPointerException("toCompare or baseTime" + SystemMessage.NULL_ARGUMENT);
	}
}
