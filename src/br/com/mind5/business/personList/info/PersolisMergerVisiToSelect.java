package br.com.mind5.business.personList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PersolisMergerVisiToSelect extends InfoMergerVisitorTemplate<PersolisInfo, PersolisInfo> {

	@Override public boolean shouldMerge(PersolisInfo baseInfo, PersolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}	
	
	

	@Override public List<PersolisInfo> merge(PersolisInfo baseInfo, PersolisInfo selectedInfo) {
		List<PersolisInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
