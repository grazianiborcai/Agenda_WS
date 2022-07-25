package br.com.mind5.discount.discountStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class DisoreMergerVisiDisorap extends InfoMergerVisitorTemplate<DisoreInfo, DisorapInfo> {

	@Override public boolean shouldMerge(DisoreInfo baseInfo, DisorapInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner	&&
				baseInfo.codStore 	 == selectedInfo.codStore	&&
				baseInfo.codDiscount == selectedInfo.codDiscount	);
	}
	
	
	
	@Override public List<DisoreInfo> merge(DisoreInfo baseInfo, DisorapInfo selectedInfo) {
		List<DisoreInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
