package br.com.mind5.business.personBio.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetVisiMergePetarch extends InfoMergerVisitorTemplate<PerbioInfo, PetarchInfo> {

	@Override public boolean shouldMerge(PerbioInfo baseInfo, PetarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<PerbioInfo> merge(PerbioInfo baseInfo, PetarchInfo selectedInfo) {
		List<PerbioInfo> results = new ArrayList<>();
		
		baseInfo.codPerson = selectedInfo.codPet;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
