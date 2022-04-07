package br.com.mind5.business.materialMovementSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatmarchMergerVisiToSelect extends InfoMergerVisitorTemplate<MatmarchInfo, MatmarchInfo> {
	
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
}
