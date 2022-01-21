package br.com.mind5.business.pet.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetVisiMergePetarch extends InfoMergerVisitorTemplate<PetInfo, PetarchInfo> {

	@Override public boolean shouldMerge(PetInfo baseInfo, PetarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<PetInfo> merge(PetInfo baseInfo, PetarchInfo selectedInfo) {
		List<PetInfo> results = new ArrayList<>();
		
		baseInfo.codPet = selectedInfo.codPet;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
