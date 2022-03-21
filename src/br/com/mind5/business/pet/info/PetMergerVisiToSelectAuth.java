package br.com.mind5.business.pet.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetMergerVisiToSelectAuth extends InfoMergerVisitorTemplate<PetInfo, PetInfo> {

	@Override public boolean shouldMerge(PetInfo baseInfo, PetInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codPet   == selectedInfo.codPet		);
	}
	
	
	
	@Override public List<PetInfo> merge(PetInfo baseInfo, PetInfo selectedInfo) {
		List<PetInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		baseInfo.codCustomer = selectedInfo.codCustomer;
		
		results.add(baseInfo);
		return results;
	}
}
