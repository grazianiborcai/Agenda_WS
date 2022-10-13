package br.com.mind5.business.store.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerVisiPereg extends InfoMergerVisitorTemplate<StoreInfo, PeregInfo> {

	@Override public boolean shouldMerge(StoreInfo baseInfo, PeregInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StoreInfo> merge(StoreInfo baseInfo, PeregInfo selectedInfo) {
		List<StoreInfo> results = new ArrayList<>();
		
		baseInfo.peregData = selectedInfo;
		baseInfo.codLegalPerson = selectedInfo.codLegalPerson;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StoreInfo> uniquifyHook(List<StoreInfo> results) {
		InfoUniquifier<StoreInfo> uniquifier = new StoreUniquifier();		
		return uniquifier.uniquify(results);
	}
}
