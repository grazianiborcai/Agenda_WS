package br.com.mind5.business.calendarDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CalateVisiMergeMooncal implements InfoMergerVisitorV3<CalateInfo, MooncalInfo> {
	
	@Override public List<CalateInfo> beforeMerge(List<CalateInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CalateInfo baseInfo, MooncalInfo selectedInfo) {
		return baseInfo.date.equals(selectedInfo.moonDate);
	}
	
	
	
	@Override public List<CalateInfo> merge(CalateInfo baseInfo, MooncalInfo selectedInfo) {
		List<CalateInfo> results = new ArrayList<>();
		
		baseInfo.txtMoonPhase = selectedInfo.txtMoonPhase;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CalateInfo> getUniquifier() {
		return null;
	}
}
