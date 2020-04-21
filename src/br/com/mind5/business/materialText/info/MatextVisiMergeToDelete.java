package br.com.mind5.business.materialText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class MatextVisiMergeToDelete implements InfoMergerVisitorV3<MatextInfo, MatextInfo> {
	
	@Override public List<MatextInfo> beforeMerge(List<MatextInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatextInfo baseInfo, MatextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&& 
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MatextInfo> merge(MatextInfo baseInfo, MatextInfo selectedInfo) {
		List<MatextInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatextInfo> getUniquifier() {
		return null;
	}
}
