package br.com.mind5.business.materialText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;


final class MatextVisiMergeMatextault extends InfoMergerVisitorTemplate<MatextInfo, MatextaultInfo> {
	
	@Override public List<MatextInfo> beforeMerge(List<MatextInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatextInfo baseInfo, MatextaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatextInfo> merge(MatextInfo baseInfo, MatextaultInfo selectedInfo) {
		List<MatextInfo> results = new ArrayList<>();
		
		MatextInfo result = MatextInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatextInfo> getUniquifier() {
		return null;
	}
}
