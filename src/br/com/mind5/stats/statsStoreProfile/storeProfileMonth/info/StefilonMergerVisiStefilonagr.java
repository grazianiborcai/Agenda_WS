package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthAggr.info.StefilonagrInfo;

final class StefilonMergerVisiStefilonagr extends InfoMergerVisitorTemplate<StefilonInfo, StefilonagrInfo> {

	@Override public boolean shouldMerge(StefilonInfo baseInfo, StefilonagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.calmonth.equals(selectedInfo.calmonth));
	}
	
	
	
	@Override public List<StefilonInfo> merge(StefilonInfo baseInfo, StefilonagrInfo selectedInfo) {
		List<StefilonInfo> results = new ArrayList<>();
		
		StefilonInfo result = StefilonInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
