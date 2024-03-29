package br.com.mind5.business.personSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.gender.info.GenderInfo;

final class PersonapMergerVisiGender extends InfoMergerVisitorTemplate<PersonapInfo, GenderInfo> {

	@Override public boolean shouldMerge(PersonapInfo baseInfo, GenderInfo selectedInfo) {
		return (baseInfo.codGender == selectedInfo.codGender);
	}
	
	

	@Override public List<PersonapInfo> merge(PersonapInfo baseInfo, GenderInfo selectedInfo) {
		List<PersonapInfo> results = new ArrayList<>();
		
		baseInfo.txtGender = selectedInfo.txtGender;
		
		results.add(baseInfo);
		return results;
	}
}
