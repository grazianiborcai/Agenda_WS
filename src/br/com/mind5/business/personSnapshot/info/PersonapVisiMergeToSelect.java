package br.com.mind5.business.personSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PersonapVisiMergeToSelect extends InfoMergerVisitorTemplate<PersonapInfo, PersonapInfo> {
	
	@Override public List<PersonapInfo> beforeMerge(List<PersonapInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PersonapInfo baseInfo, PersonapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}	
	
	

	@Override public List<PersonapInfo> merge(PersonapInfo baseInfo, PersonapInfo selectedInfo) {
		List<PersonapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PersonapInfo> getUniquifier() {
		return null;
	}
}
