package br.com.mind5.business.materialMovementSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class MatmarchVisiMergeToSelect extends InfoMergerVisitorTemplate<MatmarchInfo, MatmarchInfo> {

	@Override public List<MatmarchInfo> beforeMerge(List<MatmarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatmarchInfo baseInfo, MatmarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatmarchInfo> merge(MatmarchInfo baseInfo, MatmarchInfo selectedInfo) {
		List<MatmarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatmarchInfo> getUniquifier() {
		return null;
	}
}
