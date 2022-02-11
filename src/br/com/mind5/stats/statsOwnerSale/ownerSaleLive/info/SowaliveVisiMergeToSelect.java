package br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SowaliveVisiMergeToSelect extends InfoMergerVisitorTemplate<SowaliveInfo, SowaliveInfo> {

	@Override public boolean shouldMerge(SowaliveInfo baseInfo, SowaliveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SowaliveInfo> merge(SowaliveInfo baseInfo, SowaliveInfo selectedInfo) {
		List<SowaliveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
