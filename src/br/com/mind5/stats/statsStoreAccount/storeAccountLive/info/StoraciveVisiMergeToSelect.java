package br.com.mind5.stats.statsStoreAccount.storeAccountLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StoraciveVisiMergeToSelect extends InfoMergerVisitorTemplate<StoraciveInfo, StoraciveInfo> {

	@Override public boolean shouldMerge(StoraciveInfo baseInfo, StoraciveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoraciveInfo> merge(StoraciveInfo baseInfo, StoraciveInfo selectedInfo) {
		List<StoraciveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
