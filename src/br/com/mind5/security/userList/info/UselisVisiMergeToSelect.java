package br.com.mind5.security.userList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class UselisVisiMergeToSelect extends InfoMergerVisitorTemplate<UselisInfo, UselisInfo> {
	
	@Override public List<UselisInfo> beforeMerge(List<UselisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(UselisInfo baseInfo, UselisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}	
	
	

	@Override public List<UselisInfo> merge(UselisInfo baseInfo, UselisInfo selectedInfo) {
		List<UselisInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<UselisInfo> getUniquifier() {
		return null;
	}
}
