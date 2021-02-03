package br.com.mind5.business.materialText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;


final class MatextVisiMergeMatextault extends InfoMergerVisitorTemplate<MatextInfo, MatextaultInfo> {

	@Override public boolean shouldMerge(MatextInfo baseInfo, MatextaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatextInfo> merge(MatextInfo baseInfo, MatextaultInfo selectedInfo) {
		List<MatextInfo> results = new ArrayList<>();
		
		MatextInfo result = MatextInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
