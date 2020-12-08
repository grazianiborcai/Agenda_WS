package br.com.mind5.business.addressDefault.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class AddaultVisiMergeToSelect extends InfoMergerVisitorTemplate<AddaultInfo, AddaultInfo> {

	@Override public boolean shouldMerge(AddaultInfo baseInfo, AddaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<AddaultInfo> merge(AddaultInfo baseInfo, AddaultInfo selectedInfo) {
		List<AddaultInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
