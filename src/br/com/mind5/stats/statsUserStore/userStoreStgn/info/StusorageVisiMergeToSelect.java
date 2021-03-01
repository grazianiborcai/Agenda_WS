package br.com.mind5.stats.statsUserStore.userStoreStgn.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StusorageVisiMergeToSelect extends InfoMergerVisitorTemplate<StusorageInfo, StusorageInfo> {

	@Override public boolean shouldMerge(StusorageInfo baseInfo, StusorageInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StusorageInfo> merge(StusorageInfo baseInfo, StusorageInfo selectedInfo) {
		List<StusorageInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
