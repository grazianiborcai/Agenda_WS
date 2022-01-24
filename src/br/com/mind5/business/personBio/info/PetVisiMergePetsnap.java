package br.com.mind5.business.personBio.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetVisiMergePetsnap extends InfoMergerVisitorTemplate<PerbioInfo, PetsnapInfo> {

	@Override public boolean shouldMerge(PerbioInfo baseInfo, PetsnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codPerson   == selectedInfo.codPet		);
	}
	
	

	@Override public List<PerbioInfo> merge(PerbioInfo baseInfo, PetsnapInfo selectedInfo) {
		List<PerbioInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
