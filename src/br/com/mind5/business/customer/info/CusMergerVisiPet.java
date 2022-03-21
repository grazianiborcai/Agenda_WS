package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class CusMergerVisiPet extends InfoMergerVisitorTemplate<CusInfo, PetInfo> {

	@Override public boolean shouldMerge(CusInfo baseInfo, PetInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, PetInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		baseInfo.pets.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
