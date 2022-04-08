package br.com.mind5.business.materialStoreSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatorarchMergerVisiToSelect extends InfoMergerVisitorTemplate<MatorarchInfo, MatorarchInfo> {

	@Override public boolean shouldMerge(MatorarchInfo baseInfo, MatorarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<MatorarchInfo> merge(MatorarchInfo baseInfo, MatorarchInfo selectedInfo) {
		List<MatorarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
