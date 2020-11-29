package br.com.mind5.business.phoneSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PhonapVisiMergeToSelect extends InfoMergerVisitorTemplate<PhonapInfo, PhonapInfo> {

	@Override public boolean shouldMerge(PhonapInfo baseInfo, PhonapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PhonapInfo> merge(PhonapInfo baseInfo, PhonapInfo selectedInfo) {
		List<PhonapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
