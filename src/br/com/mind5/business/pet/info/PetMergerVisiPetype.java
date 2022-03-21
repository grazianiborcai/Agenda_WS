package br.com.mind5.business.pet.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.petType.info.PetypeInfo;

final class PetMergerVisiPetype extends InfoMergerVisitorTemplate<PetInfo, PetypeInfo> {

	@Override public boolean shouldMerge(PetInfo baseInfo, PetypeInfo selectedInfo) {
		return (baseInfo.codPetype == selectedInfo.codPetype);
	}
	
	
	
	@Override public List<PetInfo> merge(PetInfo baseInfo, PetypeInfo selectedInfo) {
		List<PetInfo> results = new ArrayList<>();
		
		baseInfo.txtPetype = selectedInfo.txtPetype;
		
		results.add(baseInfo);
		return results;
	}
}
