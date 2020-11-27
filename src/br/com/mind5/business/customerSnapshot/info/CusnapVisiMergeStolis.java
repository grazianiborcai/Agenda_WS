package br.com.mind5.business.customerSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusnapVisiMergeStolis extends InfoMergerVisitorTemplate<CusnapInfo, StolisInfo> {

	@Override public boolean shouldMerge(CusnapInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore  == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<CusnapInfo> merge(CusnapInfo baseInfo, StolisInfo selectedInfo) {
		List<CusnapInfo> results = new ArrayList<>();
		
		baseInfo.codStoreSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
