package br.com.gda.common;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DateRange {
	private final boolean SKIP = false;
	private final List<DateRange> EMPTY_RANGE = Collections.emptyList();
	
	private LocalDate beginDate; 
	private LocalDate endDate;
	
	
	public DateRange(LocalDate begin, LocalDate end) {
		checkArgument(begin, end);
		
		beginDate = LocalDate.of(begin.getYear(), begin.getMonth(), begin.getDayOfMonth());
		endDate = LocalDate.of(end.getYear(), end.getMonth(), end.getDayOfMonth());
	}
	
	
	
	public LocalDate getBeginDate() {
		return LocalDate.of(beginDate.getYear(), beginDate.getMonth(), beginDate.getDayOfMonth());
	}
	
	
	
	public LocalDate getEndDate() {
		return LocalDate.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth());
	}
	
	
	
	public List<DateRange> getMissingRanges(LocalDate begin, LocalDate end) {
		checkArgument(begin, end);
		
		if (shouldCompareRange(begin, end) == SKIP )
			return EMPTY_RANGE;
		
		List<DateRange> missingRanges = new ArrayList<>();
		missingRanges.addAll(compareBoundaryBegin(begin));
		missingRanges.addAll(compareBoundaryEnd(end));
		
		return missingRanges;
	}
	
	
	
	private void checkArgument(LocalDate begin, LocalDate end) {
		if (begin == null)
			throw new NullPointerException("begin" + SystemMessage.NULL_ARGUMENT);
		
		if (end == null)
			throw new NullPointerException("end" + SystemMessage.NULL_ARGUMENT);
		
		if (end.isBefore(begin))
			throw new IllegalArgumentException(SystemMessage.BAD_TIME_RANGE);
	}
	
	
	
	private boolean shouldCompareRange(LocalDate begin, LocalDate end) {		
		if (end.isEqual(begin))
			return SKIP;		
		
		if (beginDate.isBefore(begin) || endDate.isAfter(end))
			return true;
		
		return SKIP;
	}
	
	
	
	private List<DateRange> compareBoundaryBegin(LocalDate begin) {
		if (beginDate.isAfter(begin) || beginDate.isEqual(begin))
			return EMPTY_RANGE;
		
		List<DateRange> ranges = new ArrayList<>();
		LocalDate missingBegin = LocalDate.of(beginDate.getYear(), beginDate.getMonth(), beginDate.getDayOfMonth());
		LocalDate missingEnd = begin.minusDays(1);
		ranges.add(new DateRange(missingBegin, missingEnd));
		
		return ranges;
	}
	
	
	
	private List<DateRange> compareBoundaryEnd(LocalDate end) {
		if (endDate.isBefore(end) || endDate.isEqual(end))
			return EMPTY_RANGE;
		
		List<DateRange> ranges = new ArrayList<>();
		LocalDate missingBegin = end.plusDays(1);
		LocalDate missingEnd = LocalDate.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth());
		ranges.add(new DateRange(missingBegin, missingEnd));
		
		return ranges;
	}
}
