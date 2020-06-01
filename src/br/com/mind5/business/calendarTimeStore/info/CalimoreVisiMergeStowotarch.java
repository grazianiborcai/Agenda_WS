package br.com.mind5.business.calendarTimeStore.info;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarTime.info.CalimeInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CalimoreVisiMergeStowotarch implements InfoMergerVisitorV3<CalimoreInfo, StowotarchInfo> {
	
	@Override public List<CalimoreInfo> beforeMerge(List<CalimoreInfo> baseInfos) {
		
		for (CalimoreInfo eachBase : baseInfos) {
			eachBase.calimes = new ArrayList<>();
		}
		
		
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalimoreInfo baseInfo, StowotarchInfo selectedInfo) {
		return (baseInfo.codOwner   == selectedInfo.codOwner 	&&
				baseInfo.codStore   == selectedInfo.codStore 	&&
				baseInfo.codWeekday == selectedInfo.codWeekday		);
	}
	
	
	
	@Override public List<CalimoreInfo> merge(CalimoreInfo baseInfo, StowotarchInfo selectedInfo) {
		List<CalimoreInfo> results = new ArrayList<>();
		
		baseInfo = addFirstTimeBin(baseInfo, selectedInfo);
		baseInfo = addBetweenTimeBin(baseInfo, selectedInfo);
		baseInfo = addLastTimeBin(baseInfo, selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private CalimoreInfo addFirstTimeBin(CalimoreInfo baseInfo, StowotarchInfo selectedInfo) {
		CalimeInfo calime = new CalimeInfo();
		
		calime.timeBin = selectedInfo.beginTime;		
		baseInfo.calimes.add(calime);
		
		return baseInfo;
	}
	
	
	
	private CalimoreInfo addBetweenTimeBin(CalimoreInfo baseInfo, StowotarchInfo selectedInfo) {
		LocalTime timeBin = getNextTimeBin(selectedInfo.beginTime);
		
		while (timeBin.isBefore(selectedInfo.endTime)) {
			CalimeInfo calime = new CalimeInfo();		
			
			calime.timeBin = timeBin;		
			baseInfo.calimes.add(calime);
			
			timeBin = getNextTimeBin(timeBin);
		}		
		
		return baseInfo;
	}
	
	
	
	private CalimoreInfo addLastTimeBin(CalimoreInfo baseInfo, StowotarchInfo selectedInfo) {
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
	
	
	
	@Override public InfoUniquifier<CalimoreInfo> getUniquifier() {
		return null;
	}
}
