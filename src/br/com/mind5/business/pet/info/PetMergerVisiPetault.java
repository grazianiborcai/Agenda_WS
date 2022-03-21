package br.com.mind5.business.pet.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetMergerVisiPetault extends InfoMergerVisitorTemplate<PetInfo, PetaultInfo> {

	@Override public boolean shouldMerge(PetInfo baseInfo, PetaultInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	

	@Override public List<PetInfo> merge(PetInfo baseInfo, PetaultInfo selectedInfo) {
		List<PetInfo> results = new ArrayList<>();
		
		baseInfo.codPet = selectedInfo.codPet;
		
		results.add(baseInfo);
		return results;
	}
}
