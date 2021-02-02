package br.com.mind5.business.calendarMoon.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MooncalVisiMergeToSelect extends InfoMergerVisitorTemplate<MooncalInfo, MooncalInfo> {

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
}
