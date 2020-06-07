package br.com.mind5.business.calendarTimeEmployee.info;

import java.time.LocalTime;
import java.util.ArrayList;

import br.com.mind5.business.calendarTime.info.CalimeInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class CalimempSetterFallback extends InfoSetterTemplate<CalimempInfo> {
	
	@Override protected CalimempInfo setAttrHook(CalimempInfo recordInfo) {
		recordInfo.calimes = new ArrayList<>();
		
		LocalTime timeBin = getFirstTimeBin();
		LocalTime lastTimeBin = getLastTimeBin();
		
		
		while (timeBin.isBefore(lastTimeBin) || timeBin.equals(lastTimeBin)) {
			recordInfo = addTimeBin(timeBin, recordInfo);
			timeBin = getNextTimeBin(timeBin);
		}

		
		return recordInfo;
	}
	
	
	
	private LocalTime getFirstTimeBin() {
		return LocalTime.of(8, 0);
	}
	
	
	
	private LocalTime getLastTimeBin() {
		return LocalTime.of(20, 0);
	}
	
	
	
	private LocalTime getNextTimeBin(LocalTime timeBin) {
		return timeBin.plusHours(1);
	}	
	
	
	
	private CalimempInfo addTimeBin(LocalTime timeBin, CalimempInfo recordInfo) {
		CalimeInfo result = new CalimeInfo();
		
		result.timeBin = timeBin;
		result.isLocked = true;
		
		recordInfo.calimes.add(result);
		return recordInfo;
	}
}
