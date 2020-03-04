package br.com.mind5.business.materialStoreSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class MatorarchVisiMergeToSelect implements InfoMergerVisitorV3<MatorarchInfo, MatorarchInfo> {
	
	@Override public List<MatorarchInfo> beforeMerge(List<MatorarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<MatorarchInfo> getUniquifier() {
		return null;
	}
}
