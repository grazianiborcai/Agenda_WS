package br.com.mind5.business.orderSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdarchMergerVisiToSelect extends InfoMergerVisitorTemplate<OrdarchInfo, OrdarchInfo> {

	@Override public boolean shouldMerge(OrdarchInfo baseInfo, OrdarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<OrdarchInfo> merge(OrdarchInfo baseInfo, OrdarchInfo selectedInfo) {
		List<OrdarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
