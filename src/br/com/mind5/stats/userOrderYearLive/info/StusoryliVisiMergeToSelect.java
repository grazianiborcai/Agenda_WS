package br.com.mind5.stats.userOrderYearLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StusoryliVisiMergeToSelect extends InfoMergerVisitorTemplate<StusoryliInfo, StusoryliInfo> {

	@Override public boolean shouldMerge(StusoryliInfo baseInfo, StusoryliInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StusoryliInfo> merge(StusoryliInfo baseInfo, StusoryliInfo selectedInfo) {
		List<StusoryliInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
