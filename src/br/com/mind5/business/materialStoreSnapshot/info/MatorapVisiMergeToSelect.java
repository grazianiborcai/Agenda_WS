package br.com.mind5.business.materialStoreSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatorapVisiMergeToSelect extends InfoMergerVisitorTemplate<MatorapInfo, MatorapInfo> {

	@Override public boolean shouldMerge(MatorapInfo baseInfo, MatorapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatorapInfo> merge(MatorapInfo baseInfo, MatorapInfo selectedInfo) {
		List<MatorapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
