package br.com.mind5.discount.discountStoreSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class DisorarchVisiMergeToSelect extends InfoMergerVisitorTemplate<DisorarchInfo, DisorarchInfo> {
	@Override public boolean shouldMerge(DisorarchInfo baseInfo, DisorarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<DisorarchInfo> merge(DisorarchInfo baseInfo, DisorarchInfo selectedInfo) {
		List<DisorarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
