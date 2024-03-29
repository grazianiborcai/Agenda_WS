package br.com.mind5.business.calendarTimeEmployee.info;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTime.info.CalimeInfo;
import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalimempMergerVisiEmplarg extends InfoMergerVisitorTemplate<CalimempInfo, EmplargInfo> {

	@Override public boolean shouldMerge(CalimempInfo baseInfo, EmplargInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 		&&
				baseInfo.codStore    == selectedInfo.codStore 		&&
				baseInfo.codEmployee == selectedInfo.codEmployee 	&&
				baseInfo.calimes.isEmpty() == false						);
	}
	
	
	
	@Override public List<CalimempInfo> merge(CalimempInfo baseInfo, EmplargInfo selectedInfo) {
		List<CalimempInfo> results = new ArrayList<>();
		
		int size = baseInfo.calimes.size();
		
		for (int i=0; i < size; i++) {
			int next = getNextIndex(i, size);
			
			CalimeInfo startBin = baseInfo.calimes.get(i);
			CalimeInfo endBin = baseInfo.calimes.get(next);
			
			startBin.isLocked = hasLeaveDate(startBin, endBin, baseInfo, selectedInfo);
		}

		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private int getNextIndex(int i, int size) {
		int next = i + 1;
		
		if (next >= size)
			next = size - 1;
		
		return next;
		
	}
	
	
	
	private boolean hasLeaveDate(CalimeInfo startTimeBin, CalimeInfo endTimeBin, CalimempInfo baseInfo, EmplargInfo selectedInfo) {		
		LocalDateTime validFrom = LocalDateTime.of(selectedInfo.dateValidFrom, selectedInfo.timeValidFrom);
		LocalDateTime validTo = LocalDateTime.of(selectedInfo.dateValidTo, selectedInfo.timeValidTo);
		LocalDateTime timeBinFrom = LocalDateTime.of(baseInfo.date, startTimeBin.timeBin);
		LocalDateTime timeBinTo = LocalDateTime.of(baseInfo.date, endTimeBin.timeBin);
		
		timeBinTo = endOfDayWhenEqual(timeBinFrom, timeBinTo);
		
		if (hasLeaveDateOnBegin(timeBinFrom, validFrom, validTo) == true)
			return true;
		
		if (hasLeaveDateOnEnd(timeBinTo, validFrom, validTo) == true)
			return true;
		
		if (hasLeaveDateInBetween(timeBinFrom, timeBinTo, validFrom, validTo) == true)
			return true;
		
		return false;
	}
	
	
	
	private LocalDateTime endOfDayWhenEqual(LocalDateTime timeBinFrom, LocalDateTime timeBinTo) {
		LocalDateTime result = timeBinTo;
		
		if (timeBinFrom.isEqual(timeBinTo)) {
			LocalTime endOfday = LocalTime.of(23, 59);
			result = LocalDateTime.of(timeBinTo.toLocalDate(), endOfday);
		}
		
		return result;
	}
	
	
	
	private boolean hasLeaveDateOnBegin(LocalDateTime timeBinFrom, LocalDateTime validFrom, LocalDateTime validTo) {
		boolean isBeginValid = false;
		boolean isEndValid = false;
		
		
		if (validFrom.isBefore(timeBinFrom) || validFrom.isEqual(timeBinFrom))
			isBeginValid = true;
		
		if (validTo.isAfter(timeBinFrom) || validTo.isEqual(timeBinFrom))
			isEndValid = true;
		
		return (isBeginValid == true && 
			    isEndValid   == true	);
	}
	
	
	
	private boolean hasLeaveDateOnEnd(LocalDateTime timeBinTo, LocalDateTime validFrom, LocalDateTime validTo) {
		boolean isBeginValid = false;
		boolean isEndValid = false;
		
		
		if (validFrom.isBefore(timeBinTo) || validFrom.isEqual(timeBinTo))
			isBeginValid = true;
		
		if (validTo.isAfter(timeBinTo) || validTo.isEqual(timeBinTo))
			isEndValid = true;

		
		return (isBeginValid == true && 
			    isEndValid   == true	);
	}
	
	
	
	private boolean hasLeaveDateInBetween(LocalDateTime timeBinFrom, LocalDateTime timeBinTo, LocalDateTime validFrom, LocalDateTime validTo) {
		boolean isBeginValid = false;
		boolean isEndValid = false;		
		
		if (validFrom.isAfter(timeBinFrom) || validFrom.isEqual(timeBinFrom))
			isBeginValid = true;
		
		if (validTo.isBefore(timeBinTo) || validTo.isEqual(timeBinTo))
			isEndValid = true;
		
		return (isBeginValid == true && 
			    isEndValid   == true	);
	}
}
