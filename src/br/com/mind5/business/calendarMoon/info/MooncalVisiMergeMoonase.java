package br.com.mind5.business.calendarMoon.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;

final class MooncalVisiMergeMoonase implements InfoMergerVisitor<MooncalInfo, MoonaseInfo> {
	
	@Override public List<MooncalInfo> beforeMerge(List<MooncalInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MooncalInfo baseInfo, MoonaseInfo selectedInfo) {
		return (baseInfo.codMoonPhase == selectedInfo.codMoonPhase);
	}
	
	
	
	@Override public List<MooncalInfo> merge(MooncalInfo baseInfo, MoonaseInfo selectedInfo) {
		List<MooncalInfo> results = new ArrayList<>();
		
		baseInfo.txtMoonPhase = selectedInfo.txtMoonPhase;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MooncalInfo> getUniquifier() {
		return null;
	}
}
