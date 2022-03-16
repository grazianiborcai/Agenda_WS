package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeAccount.info.StoracInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class StolisMergerVisiStorac extends InfoMergerVisitorTemplate<StolisInfo, StoracInfo> {

	@Override public boolean shouldMerge(StolisInfo baseInfo, StoracInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, StoracInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		baseInfo.isAccountCompleted = selectedInfo.isAccountCompleted;
		
		results.add(baseInfo);
		return results;
	}
}
