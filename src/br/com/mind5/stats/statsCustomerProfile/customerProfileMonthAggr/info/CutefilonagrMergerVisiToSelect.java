package br.com.mind5.stats.statsCustomerProfile.customerProfileMonthAggr.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CutefilonagrMergerVisiToSelect extends InfoMergerVisitorTemplate<CutefilonagrInfo, CutefilonagrInfo> {

	@Override public boolean shouldMerge(CutefilonagrInfo baseInfo, CutefilonagrInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CutefilonagrInfo> merge(CutefilonagrInfo baseInfo, CutefilonagrInfo selectedInfo) {
		List<CutefilonagrInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
