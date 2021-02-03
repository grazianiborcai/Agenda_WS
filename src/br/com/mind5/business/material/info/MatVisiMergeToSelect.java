package br.com.mind5.business.material.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatVisiMergeToSelect extends InfoMergerVisitorTemplate<MatInfo, MatInfo> {

	@Override public boolean shouldMerge(MatInfo baseInfo, MatInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatInfo> merge(MatInfo baseInfo, MatInfo selectedInfo) {
		List<MatInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
