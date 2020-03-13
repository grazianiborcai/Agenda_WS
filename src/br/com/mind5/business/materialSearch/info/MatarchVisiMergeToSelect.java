package br.com.mind5.business.materialSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class MatarchVisiMergeToSelect implements InfoMergerVisitorV3<MatarchInfo, MatarchInfo> {
	
	@Override public List<MatarchInfo> beforeMerge(List<MatarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<MatarchInfo> getUniquifier() {
		return null;
	}
}
