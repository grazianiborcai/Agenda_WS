package br.com.mind5.business.calendarDate.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.calendarMoon.info.MooncalInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CalateVisiMergeMooncal extends InfoMergerVisitorTemplate<CalateInfo, MooncalInfo> {	
	
	@Override public boolean shouldMerge(CalateInfo baseInfo, MooncalInfo selectedInfo) {
		return baseInfo.date.equals(selectedInfo.moonDate);
	}
	
	
	
	@Override public List<CalateInfo> merge(CalateInfo baseInfo, MooncalInfo selectedInfo) {
		List<CalateInfo> results = new ArrayList<>();
		
		baseInfo.codMoonPhase = selectedInfo.codMoonPhase;
		baseInfo.txtMoonPhase = selectedInfo.txtMoonPhase;
		
		results.add(baseInfo);
		return results;
	}
}
