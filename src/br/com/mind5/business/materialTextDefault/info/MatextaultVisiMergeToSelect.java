package br.com.mind5.business.materialTextDefault.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatextaultVisiMergeToSelect implements InfoMergerVisitor<MatextaultInfo, MatextaultInfo> {
	
	@Override public List<MatextaultInfo> beforeMerge(List<MatextaultInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatextaultInfo baseInfo, MatextaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatextaultInfo> merge(MatextaultInfo baseInfo, MatextaultInfo selectedInfo) {
		List<MatextaultInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatextaultInfo> getUniquifier() {
		return null;
	}
}
