package br.com.mind5.business.materialSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatarchMergerVisiToSelect extends InfoMergerVisitorTemplate<MatarchInfo, MatarchInfo> {
	
	@Override public boolean shouldMerge(MatarchInfo baseInfo, MatarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatarchInfo> merge(MatarchInfo baseInfo, MatarchInfo selectedInfo) {
		List<MatarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
