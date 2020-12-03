package br.com.mind5.discount.discountStore.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.discount.discountStoreSearch.info.DisorarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class DisoreVisiMergeDisorarch extends InfoMergerVisitorTemplate<DisoreInfo, DisorarchInfo> {

	@Override public boolean shouldMerge(DisoreInfo baseInfo, DisorarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<DisoreInfo> merge(DisoreInfo baseInfo, DisorarchInfo selectedInfo) {
		List<DisoreInfo> results = new ArrayList<>();
		
		DisoreInfo result = DisoreInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
