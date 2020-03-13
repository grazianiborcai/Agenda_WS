package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class MatVisiMergeMatCateg implements InfoMergerVisitorV3<MatInfo, MatCategInfo> {
	
	@Override public List<MatInfo> beforeMerge(List<MatInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatInfo baseInfo, MatCategInfo selectedInfo) {
		return (baseInfo.codMatCateg == selectedInfo.codMatCateg);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MatCategInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		baseInfo.txtMatCateg = baseInfo.txtMatCateg;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatInfo> getUniquifier() {
		return null;
	}
}
