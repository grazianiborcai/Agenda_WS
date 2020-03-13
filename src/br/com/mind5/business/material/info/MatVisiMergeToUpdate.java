package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class MatVisiMergeToUpdate implements InfoMergerVisitorV3<MatInfo, MatInfo> {
	
	@Override public List<MatInfo> beforeMerge(List<MatInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatInfo baseInfo, MatInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codMat   == selectedInfo.codMat		);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MatInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.createdBy = selectedInfo.createdBy;
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.codMatCateg = selectedInfo.codMatCateg;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatInfo> getUniquifier() {
		return null;
	}
}
