package br.com.mind5.business.orderItemSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdemrapMergerVisiStolis extends InfoMergerVisitorTemplate<OrdemrapInfo, StolisInfo> {

	@Override public boolean shouldMerge(OrdemrapInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codStore == selectedInfo.codStore	);
	}
	
	
	
	@Override public List<OrdemrapInfo> merge(OrdemrapInfo baseInfo, StolisInfo selectedInfo) {
		List<OrdemrapInfo> results = new ArrayList<>();
		
		baseInfo.codStoreSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
