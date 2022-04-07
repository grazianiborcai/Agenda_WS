package br.com.mind5.business.materialMovement.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatmovMergerVisiToSelect extends InfoMergerVisitorTemplate<MatmovInfo, MatmovInfo> {

	@Override public boolean shouldMerge(MatmovInfo baseInfo, MatmovInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatmovInfo> merge(MatmovInfo baseInfo, MatmovInfo selectedInfo) {
		List<MatmovInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
