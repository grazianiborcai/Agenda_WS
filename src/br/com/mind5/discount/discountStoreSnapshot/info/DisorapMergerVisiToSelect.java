package br.com.mind5.discount.discountStoreSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class DisorapMergerVisiToSelect extends InfoMergerVisitorTemplate<DisorapInfo, DisorapInfo> {
	@Override public boolean shouldMerge(DisorapInfo baseInfo, DisorapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<DisorapInfo> merge(DisorapInfo baseInfo, DisorapInfo selectedInfo) {
		List<DisorapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
