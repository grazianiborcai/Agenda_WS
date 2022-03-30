package br.com.mind5.business.person.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.gender.info.GenderInfo;

final class PersonMergerVisiGender extends InfoMergerVisitorTemplate<PersonInfo, GenderInfo> {

	@Override public boolean shouldMerge(PersonInfo baseInfo, GenderInfo selectedInfo) {
		return (baseInfo.codGender == selectedInfo.codGender);
	}
	
	

	@Override public List<PersonInfo> merge(PersonInfo baseInfo, GenderInfo selectedInfo) {
		List<PersonInfo> results = new ArrayList<>();
		
		baseInfo.txtGender = selectedInfo.txtGender;
		
		results.add(baseInfo);
		return results;
	}
}
