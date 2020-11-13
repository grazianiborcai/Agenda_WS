package br.com.mind5.business.calendarMoon.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MooncalVisiMergeToSelect implements InfoMergerVisitor<MooncalInfo, MooncalInfo> {
	
	@Override public List<MooncalInfo> beforeMerge(List<MooncalInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MooncalInfo baseInfo, MooncalInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<MooncalInfo> merge(MooncalInfo baseInfo, MooncalInfo selectedInfo) {
		List<MooncalInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MooncalInfo> getUniquifier() {
		return null;
	}
}
