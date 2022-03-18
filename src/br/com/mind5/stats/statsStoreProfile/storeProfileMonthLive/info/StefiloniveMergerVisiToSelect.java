package br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StefiloniveMergerVisiToSelect extends InfoMergerVisitorTemplate<StefiloniveInfo, StefiloniveInfo> {

	@Override public boolean shouldMerge(StefiloniveInfo baseInfo, StefiloniveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StefiloniveInfo> merge(StefiloniveInfo baseInfo, StefiloniveInfo selectedInfo) {
		List<StefiloniveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
