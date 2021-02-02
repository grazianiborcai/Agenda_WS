package br.com.mind5.business.calendarMoon.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;

final class MooncalVisiMergeMoonase extends InfoMergerVisitorTemplate<MooncalInfo, MoonaseInfo> {

	@Override public boolean shouldMerge(MooncalInfo baseInfo, MoonaseInfo selectedInfo) {
		return (baseInfo.codMoonPhase == selectedInfo.codMoonPhase);
	}
	
	
	
	@Override public List<MooncalInfo> merge(MooncalInfo baseInfo, MoonaseInfo selectedInfo) {
		List<MooncalInfo> results = new ArrayList<>();
		
		baseInfo.txtMoonPhase = selectedInfo.txtMoonPhase;
		
		results.add(baseInfo);
		return results;
	}
}
