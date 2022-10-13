package br.com.mind5.business.storeSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StorapMergerVisiPersonap extends InfoMergerVisitorTemplate<StorapInfo, PeregInfo> {

	@Override public boolean shouldMerge(StorapInfo baseInfo, PeregInfo selectedInfo) {
		return (baseInfo.codOwner   	== selectedInfo.codOwner		&&
				baseInfo.codLegalPerson == selectedInfo.codLegalPerson		);
	}
	
	
	
	@Override public List<StorapInfo> merge(StorapInfo baseInfo, PeregInfo selectedInfo) {
		List<StorapInfo> results = new ArrayList<>();
		
		baseInfo.peregData = PeregInfo.copyFrom(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StorapInfo> uniquifyHook(List<StorapInfo> results) {
		InfoUniquifier<StorapInfo> uniquifier = new StorapUniquifier();		
		return uniquifier.uniquify(results);
	}
}
