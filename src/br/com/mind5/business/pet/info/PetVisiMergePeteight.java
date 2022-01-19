package br.com.mind5.business.pet.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.petWeight.info.PeteightInfo;

final class PetVisiMergePeteight extends InfoMergerVisitorTemplate<PetInfo, PeteightInfo> {

	@Override public boolean shouldMerge(PetInfo baseInfo, PeteightInfo selectedInfo) {
		return (baseInfo.codPeteight == selectedInfo.codPeteight);
	}
	
	
	
	@Override public List<PetInfo> merge(PetInfo baseInfo, PeteightInfo selectedInfo) {
		List<PetInfo> results = new ArrayList<>();
		
		baseInfo.txtPeteightKg = selectedInfo.txtPeteightKg;
		
		results.add(baseInfo);
		return results;
	}
}
