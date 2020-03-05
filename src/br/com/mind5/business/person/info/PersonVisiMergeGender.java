package br.com.mind5.business.person.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.GenderInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class PersonVisiMergeGender implements InfoMergerVisitorV3<PersonInfo, GenderInfo> {
	
	@Override public List<PersonInfo> beforeMerge(List<PersonInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PersonInfo baseInfo, GenderInfo selectedInfo) {
		return (baseInfo.codGender == selectedInfo.codGender);
	}
	
	

	@Override public List<PersonInfo> merge(PersonInfo baseInfo, GenderInfo selectedInfo) {
		List<PersonInfo> results = new ArrayList<>();
		
		baseInfo.txtGender = selectedInfo.txtGender;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PersonInfo> getUniquifier() {
		return null;
	}
}
