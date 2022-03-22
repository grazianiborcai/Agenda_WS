package br.com.mind5.business.customerList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CuslisMergerVisiToSelect extends InfoMergerVisitorTemplate<CuslisInfo, CuslisInfo> {

	@Override public boolean shouldMerge(CuslisInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CuslisInfo> merge(CuslisInfo baseInfo, CuslisInfo selectedInfo) {
		List<CuslisInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
