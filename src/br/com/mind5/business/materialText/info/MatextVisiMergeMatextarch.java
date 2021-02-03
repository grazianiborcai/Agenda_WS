package br.com.mind5.business.materialText.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatextVisiMergeMatextarch extends InfoMergerVisitorTemplate<MatextInfo, MatextarchInfo> {

	@Override public boolean shouldMerge(MatextInfo baseInfo, MatextarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatextInfo> merge(MatextInfo baseInfo, MatextarchInfo selectedInfo) {
		List<MatextInfo> results = new ArrayList<>();
		
		MatextInfo result = MatextInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
