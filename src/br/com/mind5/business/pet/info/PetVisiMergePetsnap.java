package br.com.mind5.business.pet.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetVisiMergePetsnap extends InfoMergerVisitorTemplate<PetInfo, PetsnapInfo> {

	@Override public boolean shouldMerge(PetInfo baseInfo, PetsnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codPet   == selectedInfo.codPet		);
	}
	
	

	@Override public List<PetInfo> merge(PetInfo baseInfo, PetsnapInfo selectedInfo) {
		List<PetInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
