package br.com.mind5.business.materialText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class MatextVisiMergeToUpdate implements InfoMergerVisitorV3<MatextInfo, MatextInfo> {
	
	@Override public List<MatextInfo> beforeMerge(List<MatextInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatextInfo baseInfo, MatextInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codMat   == selectedInfo.codMat   &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<MatextInfo> merge(MatextInfo baseInfo, MatextInfo selectedInfo) {
		List<MatextInfo> results = new ArrayList<>();
		
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.createdBy = selectedInfo.createdBy;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatextInfo> getUniquifier() {
		return null;
	}
}
