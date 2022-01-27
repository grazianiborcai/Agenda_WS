package br.com.mind5.business.scheduleLineSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedinapVisiMergePetlis extends InfoMergerVisitorTemplate<SchedinapInfo, PetlisInfo> {

	@Override public boolean shouldMerge(SchedinapInfo baseInfo, PetlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codPet   == selectedInfo.codPet		);
	}
	
	
	
	@Override public List<SchedinapInfo> merge(SchedinapInfo baseInfo, PetlisInfo selectedInfo) {
		List<SchedinapInfo> results = new ArrayList<>();
		
		baseInfo.codPetSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
