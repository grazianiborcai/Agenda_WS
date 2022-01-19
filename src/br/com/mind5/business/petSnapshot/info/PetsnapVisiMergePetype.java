package br.com.mind5.business.petSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.petType.info.PetypeInfo;

final class PetsnapVisiMergePetype extends InfoMergerVisitorTemplate<PetsnapInfo, PetypeInfo> {

	@Override public boolean shouldMerge(PetsnapInfo baseInfo, PetypeInfo selectedInfo) {
		return (baseInfo.codPetype == selectedInfo.codPetype);
	}
	
	
	
	@Override public List<PetsnapInfo> merge(PetsnapInfo baseInfo, PetypeInfo selectedInfo) {
		List<PetsnapInfo> results = new ArrayList<>();
		
		baseInfo.txtPetype = selectedInfo.txtPetype;
		
		results.add(baseInfo);
		return results;
	}
}
