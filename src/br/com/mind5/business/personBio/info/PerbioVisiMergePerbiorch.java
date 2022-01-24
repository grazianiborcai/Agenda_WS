package br.com.mind5.business.personBio.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PerbioVisiMergePerbiorch extends InfoMergerVisitorTemplate<PerbioInfo, PerbiorchInfo> {

	@Override public boolean shouldMerge(PerbioInfo baseInfo, PerbiorchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<PerbioInfo> merge(PerbioInfo baseInfo, PerbiorchInfo selectedInfo) {
		List<PerbioInfo> results = new ArrayList<>();
		
		baseInfo.codPerson = selectedInfo.codPerson;
		baseInfo.codLanguage = selectedInfo.codLanguage;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
