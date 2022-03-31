package br.com.mind5.business.addressSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddarchMergerVisiToSelect extends InfoMergerVisitorTemplate<AddarchInfo, AddarchInfo> {

	@Override public boolean shouldMerge(AddarchInfo baseInfo, AddarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<AddarchInfo> merge(AddarchInfo baseInfo, AddarchInfo selectedInfo) {
		List<AddarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
