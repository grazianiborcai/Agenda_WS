package br.com.mind5.business.orderItemList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class OrdemistMergerVisiToSelect extends InfoMergerVisitorTemplate<OrdemistInfo, OrdemistInfo> {

	@Override public boolean shouldMerge(OrdemistInfo baseInfo, OrdemistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<OrdemistInfo> merge(OrdemistInfo baseInfo, OrdemistInfo selectedInfo) {
		List<OrdemistInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
