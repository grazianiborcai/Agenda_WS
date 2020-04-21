package br.com.mind5.business.materialText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class MatextVisiMergeMatextarch implements InfoMergerVisitorV3<MatextInfo, MatextarchInfo> {
	
	@Override public List<MatextInfo> beforeMerge(List<MatextInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatextInfo baseInfo, MatextarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatextInfo> merge(MatextInfo baseInfo, MatextarchInfo selectedInfo) {
		List<MatextInfo> results = new ArrayList<>();
		
		MatextInfo result = MatextInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatextInfo> getUniquifier() {
		return null;
	}
}
