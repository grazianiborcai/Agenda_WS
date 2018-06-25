package br.com.gda.common;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TimeRange {
	private final boolean SKIP = false;
	private final List<TimeRange> EMPTY_RANGE = Collections.emptyList();
	
	private LocalTime beginTime; 
	private LocalTime endTime;
	
	
	public TimeRange(LocalTime begin, LocalTime end) {
		checkArgument(begin, end);
		
		beginTime = LocalTime.of(begin.getHour(), begin.getMinute());
		endTime = LocalTime.of(end.getHour(), end.getMinute());
	}
	
	
	
	public LocalTime getBeginTime() {
		return LocalTime.of(beginTime.getHour(), beginTime.getMinute());
	}
	
	
	
	public LocalTime getEndTime() {
		return LocalTime.of(endTime.getHour(), endTime.getMinute());
	}
	
	
	
	public List<TimeRange> getMissingRanges(LocalTime begin, LocalTime end) {
		checkArgument(begin, end);
		
		if (shouldCompareRange(begin, end) == SKIP )
			return EMPTY_RANGE;
		
		List<TimeRange> missingRanges = new ArrayList<>();
		missingRanges.addAll(compareBoundaryBegin(begin));
		missingRanges.addAll(compareBoundaryEnd(end));
		
		return missingRanges;
	}
	
	
	
	private void checkArgument(LocalTime begin, LocalTime end) {
		if (begin == null)
			throw new NullPointerException("begin" + SystemMessage.NULL_ARGUMENT);
		
		if (end == null)
			throw new NullPointerException("end" + SystemMessage.NULL_ARGUMENT);
		
		if (end.isBefore(begin))
			throw new IllegalArgumentException(SystemMessage.BAD_TIME_RANGE);
	}
	
	
	
	private boolean shouldCompareRange(LocalTime begin, LocalTime end) {
		if (isEqual(begin, end))
			return SKIP;
		
		if (beginTime.isBefore(begin) || endTime.isAfter(end))
			return true;
		
		return SKIP;
	}
	
	
	
	private List<TimeRange> compareBoundaryBegin(LocalTime begin) {
		if (beginTime.isAfter(begin) || isEqual(beginTime, begin))
			return EMPTY_RANGE;
		
		List<TimeRange> ranges = new ArrayList<>();
		LocalTime missingBegin = LocalTime.of(beginTime.getHour(), beginTime.getMinute());
		LocalTime missingEnd = begin.minusMinutes(1);
		ranges.add(new TimeRange(missingBegin, missingEnd));
		
		return ranges;
	}
	
	
	
	private List<TimeRange> compareBoundaryEnd(LocalTime end) {
		if (endTime.isBefore(end) || isEqual(endTime, end))
			return EMPTY_RANGE;
		
		List<TimeRange> ranges = new ArrayList<>();
		LocalTime missingBegin = end.plusMinutes(1);
		LocalTime missingEnd = LocalTime.of(endTime.getHour(), endTime.getMinute());
		ranges.add(new TimeRange(missingBegin, missingEnd));
		
		return ranges;
	}
	
	
	
	private boolean isEqual(LocalTime time1, LocalTime time2) {
		if (time1.isBefore(time2) || time1.isAfter(time2))
			return false;
		
		return true;
	}
}
