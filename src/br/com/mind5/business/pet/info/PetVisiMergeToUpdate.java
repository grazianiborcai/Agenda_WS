package br.com.mind5.business.pet.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetVisiMergeToUpdate extends InfoMergerVisitorTemplate<PetInfo, PetInfo> {

	@Override public boolean shouldMerge(PetInfo baseInfo, PetInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codPet   == selectedInfo.codPet		);
	}
	
	
	
	@Override public List<PetInfo> merge(PetInfo baseInfo, PetInfo selectedInfo) {
		List<PetInfo> results = new ArrayList<>();
		
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.createdBy = selectedInfo.createdBy;
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
}
