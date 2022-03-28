package br.com.mind5.business.petList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetlisMergerVisiPetSearch extends InfoMergerVisitorTemplate<PetlisInfo, PetInfo> {

	@Override public boolean shouldMerge(PetlisInfo baseInfo, PetInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PetlisInfo> merge(PetlisInfo baseInfo, PetInfo selectedInfo) {
		List<PetlisInfo> results = new ArrayList<>();
		PetlisInfo result = PetlisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
