package br.com.mind5.business.materialSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatsnapMergerVisiToSelect extends InfoMergerVisitorTemplate<MatsnapInfo, MatsnapInfo> {

	@Override public boolean shouldMerge(MatsnapInfo baseInfo, MatsnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatsnapInfo> merge(MatsnapInfo baseInfo, MatsnapInfo selectedInfo) {
		List<MatsnapInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
