package br.com.mind5.stats.statsStoreProfile.storeProfileMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsStoreProfile.storeProfileMonthLive.info.StefiloniveInfo;

final class StefilonMergerVisiStefilonive extends InfoMergerVisitorTemplate<StefilonInfo, StefiloniveInfo> {

	@Override public boolean shouldMerge(StefilonInfo baseInfo, StefiloniveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.calmonth.equals(selectedInfo.calmonth));
	}
	
	
	
	@Override public List<StefilonInfo> merge(StefilonInfo baseInfo, StefiloniveInfo selectedInfo) {
		List<StefilonInfo> results = new ArrayList<>();
		
		StefilonInfo result = StefilonInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
