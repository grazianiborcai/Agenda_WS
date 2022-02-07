package br.com.mind5.stats.statsUserAccount.userAccount.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;

final class SuseracVisiMergeSuseracive extends InfoMergerVisitorTemplate<SuseracInfo, SuseraciveInfo> {

	@Override public boolean shouldMerge(SuseracInfo baseInfo, SuseraciveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SuseracInfo> merge(SuseracInfo baseInfo, SuseraciveInfo selectedInfo) {
		List<SuseracInfo> results = new ArrayList<>();
		
		SuseracInfo result = SuseracInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
