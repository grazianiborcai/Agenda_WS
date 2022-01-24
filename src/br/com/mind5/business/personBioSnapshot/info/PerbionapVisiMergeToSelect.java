package br.com.mind5.business.personBioSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PerbionapVisiMergeToSelect extends InfoMergerVisitorTemplate<PerbionapInfo, PerbionapInfo> {

	@Override public boolean shouldMerge(PerbionapInfo baseInfo, PerbionapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PerbionapInfo> merge(PerbionapInfo baseInfo, PerbionapInfo selectedInfo) {
		List<PerbionapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
