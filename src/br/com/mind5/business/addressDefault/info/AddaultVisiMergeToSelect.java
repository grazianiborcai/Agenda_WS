package br.com.mind5.business.addressDefault.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class AddaultVisiMergeToSelect implements InfoMergerVisitorV3<AddaultInfo, AddaultInfo> {
	
	@Override public List<AddaultInfo> beforeMerge(List<AddaultInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<AddaultInfo> getUniquifier() {
		return null;
	}
}
