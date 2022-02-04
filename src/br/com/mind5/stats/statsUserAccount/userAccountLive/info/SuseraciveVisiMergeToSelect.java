package br.com.mind5.stats.statsUserAccount.userAccountLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SuseraciveVisiMergeToSelect extends InfoMergerVisitorTemplate<SuseraciveInfo, SuseraciveInfo> {

	@Override public boolean shouldMerge(SuseraciveInfo baseInfo, SuseraciveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SuseraciveInfo> merge(SuseraciveInfo baseInfo, SuseraciveInfo selectedInfo) {
		List<SuseraciveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
