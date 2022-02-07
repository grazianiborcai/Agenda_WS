package br.com.mind5.stats.statsOwnerUser.userAccountLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowusiveVisiMergeToSelect extends InfoMergerVisitorTemplate<SowusiveInfo, SowusiveInfo> {

	@Override public boolean shouldMerge(SowusiveInfo baseInfo, SowusiveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowusiveInfo> merge(SowusiveInfo baseInfo, SowusiveInfo selectedInfo) {
		List<SowusiveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
