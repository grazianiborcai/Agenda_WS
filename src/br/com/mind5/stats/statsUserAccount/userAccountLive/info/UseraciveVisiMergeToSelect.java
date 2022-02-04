package br.com.mind5.stats.statsUserAccount.userAccountLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class UseraciveVisiMergeToSelect extends InfoMergerVisitorTemplate<UseraciveInfo, UseraciveInfo> {

	@Override public boolean shouldMerge(UseraciveInfo baseInfo, UseraciveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<UseraciveInfo> merge(UseraciveInfo baseInfo, UseraciveInfo selectedInfo) {
		List<UseraciveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
