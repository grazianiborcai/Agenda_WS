package br.com.mind5.business.addressSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class AddarchVisiMergeToSelect implements InfoMergerVisitorV3<AddarchInfo, AddarchInfo> {
	
	@Override public List<AddarchInfo> beforeMerge(List<AddarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<AddarchInfo> getUniquifier() {
		return null;
	}
}
