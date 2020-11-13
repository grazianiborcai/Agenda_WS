package br.com.mind5.business.materialTextSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatextsnapVisiMergeToSelect implements InfoMergerVisitor<MatextsnapInfo, MatextsnapInfo> {

	@Override public List<MatextsnapInfo> beforeMerge(List<MatextsnapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatextsnapInfo baseInfo, MatextsnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatextsnapInfo> merge(MatextsnapInfo baseInfo, MatextsnapInfo selectedInfo) {
		List<MatextsnapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatextsnapInfo> getUniquifier() {
		return null;
	}
}
