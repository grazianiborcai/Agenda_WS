package br.com.mind5.business.personList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PersolisVisiMergeToSelect extends InfoMergerVisitorTemplate<PersolisInfo, PersolisInfo> {
	
	@Override public List<PersolisInfo> beforeMerge(List<PersolisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PersolisInfo baseInfo, PersolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}	
	
	

	@Override public List<PersolisInfo> merge(PersolisInfo baseInfo, PersolisInfo selectedInfo) {
		List<PersolisInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PersolisInfo> getUniquifier() {
		return null;
	}
}
