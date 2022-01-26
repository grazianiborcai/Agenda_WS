package br.com.mind5.business.petDefault.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetaultVisiMergeToSelect extends InfoMergerVisitorTemplate<PetaultInfo, PetaultInfo> {

	@Override public boolean shouldMerge(PetaultInfo baseInfo, PetaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<PetaultInfo> merge(PetaultInfo baseInfo, PetaultInfo selectedInfo) {
		List<PetaultInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
