package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthLive.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CutefiloniveMergerVisiToSelect extends InfoMergerVisitorTemplate<CutefiloniveInfo, CutefiloniveInfo> {

	@Override public boolean shouldMerge(CutefiloniveInfo baseInfo, CutefiloniveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CutefiloniveInfo> merge(CutefiloniveInfo baseInfo, CutefiloniveInfo selectedInfo) {
		List<CutefiloniveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
