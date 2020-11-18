package br.com.mind5.business.person.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PersonVisiMergeToSelect extends InfoMergerVisitorTemplate<PersonInfo, PersonInfo> {
	
	@Override public List<PersonInfo> beforeMerge(List<PersonInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PersonInfo baseInfo, PersonInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}	
	
	

	@Override public List<PersonInfo> merge(PersonInfo baseInfo, PersonInfo selectedInfo) {
		List<PersonInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PersonInfo> getUniquifier() {
		return null;
	}
}
