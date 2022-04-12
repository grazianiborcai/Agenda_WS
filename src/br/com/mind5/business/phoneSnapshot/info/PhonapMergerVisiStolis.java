package br.com.mind5.business.phoneSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhonapMergerVisiStolis extends InfoMergerVisitorTemplate<PhonapInfo, StolisInfo> {

	@Override public boolean shouldMerge(PhonapInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<PhonapInfo> merge(PhonapInfo baseInfo, StolisInfo selectedInfo) {
		List<PhonapInfo> results = new ArrayList<>();
		
		baseInfo.codStoreSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
