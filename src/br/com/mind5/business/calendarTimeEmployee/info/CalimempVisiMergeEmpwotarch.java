package br.com.mind5.business.calendarTimeEmployee.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTime.info.CalimeInfo;
import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CalimempVisiMergeEmpwotarch implements InfoMergerVisitorV3<CalimempInfo, EmpwotarchInfo> {
	
	@Override public List<CalimempInfo> beforeMerge(List<CalimempInfo> baseInfos) {
		
		for (CalimempInfo eachBase : baseInfos) {
			eachBase.calimes = new ArrayList<>();
		}
		
		
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalimempInfo baseInfo, EmpwotarchInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner 		&&
				baseInfo.codStore    == selectedInfo.codStore 		&&
				baseInfo.codEmployee == selectedInfo.codEmployee 	&&
				baseInfo.codWeekday  == selectedInfo.codWeekday			);
	}
	
	
	
	@Override public List<CalimempInfo> merge(CalimempInfo baseInfo, EmpwotarchInfo selectedInfo) {
		List<CalimempInfo> results = new ArrayList<>();
		
		baseInfo = addFirstTimeBin(baseInfo, selectedInfo);
		baseInfo = addBetweenTimeBin(baseInfo, selectedInfo);
		baseInfo = addLastTimeBin(baseInfo, selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private CalimempInfo addFirstTimeBin(CalimempInfo baseInfo, EmpwotarchInfo selectedInfo) {
		CalimeInfo calime = new CalimeInfo();
		
		calime.timeBin = selectedInfo.beginTime;		
		baseInfo.calimes.add(calime);
		
		return baseInfo;
	}
	
	
	
	private CalimempInfo addBetweenTimeBin(CalimempInfo baseInfo, EmpwotarchInfo selectedInfo) {
		LocalTime timeBin = getNextTimeBin(selectedInfo.beginTime);
		
		while (timeBin.isBefore(selectedInfo.endTime)) {
			CalimeInfo calime = new CalimeInfo();		
			
			calime.timeBin = timeBin;		
			baseInfo.calimes.add(calime);
			
			timeBin = getNextTimeBin(timeBin);
		}		
		
		return baseInfo;
	}
	
	
	
	private CalimempInfo addLastTimeBin(CalimempInfo baseInfo, EmpwotarchInfo selectedInfo) {
		CalimeInfo calime = new CalimeInfo();
		
		calime.timeBin = selectedInfo.endTime;		
		baseInfo.calimes.add(calime);
		
		return baseInfo;
	}
	
	
	
	private LocalTime getNextTimeBin(LocalTime timeBin) {
		timeBin = timeBin.plusHours(1);		
		long min = timeBin.getMinute();
		
		if (min > 0)
			timeBin = timeBin.minusMinutes(min);
		
		return timeBin;
	}
	
	
	
	@Override public InfoUniquifier<CalimempInfo> getUniquifier() {
		return null;
	}
}
