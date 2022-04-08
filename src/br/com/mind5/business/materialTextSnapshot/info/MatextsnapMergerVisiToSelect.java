package br.com.mind5.business.materialTextSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatextsnapMergerVisiToSelect extends InfoMergerVisitorTemplate<MatextsnapInfo, MatextsnapInfo> {

	@Override public boolean shouldMerge(MatextsnapInfo baseInfo, MatextsnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatextsnapInfo> merge(MatextsnapInfo baseInfo, MatextsnapInfo selectedInfo) {
		List<MatextsnapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
