package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class MatlisVisiMergeToSelect extends InfoMergerVisitorTemplate<MatlisInfo, MatlisInfo> {
	
	@Override public List<MatlisInfo> beforeMerge(List<MatlisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(MatlisInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatlisInfo> merge(MatlisInfo baseInfo, MatlisInfo selectedInfo) {
		List<MatlisInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<MatlisInfo> getUniquifier() {
		return null;
	}
}
