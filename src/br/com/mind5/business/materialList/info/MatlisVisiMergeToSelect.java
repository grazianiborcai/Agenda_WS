package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatlisVisiMergeToSelect extends InfoMergerVisitorTemplate<MatlisInfo, MatlisInfo> {

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
}
