package br.com.mind5.business.petList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetlisVisiMergePet extends InfoMergerVisitorTemplate<PetlisInfo, PetInfo> {

	@Override public boolean shouldMerge(PetlisInfo baseInfo, PetInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codPet   == selectedInfo.codPet);
	}
	
	
	
	@Override public List<PetlisInfo> merge(PetlisInfo baseInfo, PetInfo selectedInfo) {
		List<PetlisInfo> results = new ArrayList<>();
		PetlisInfo result = PetlisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
