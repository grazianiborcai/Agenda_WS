package br.com.mind5.business.petSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.petWeight.info.PeteightInfo;

final class PetsnapVisiMergePeteight extends InfoMergerVisitorTemplate<PetsnapInfo, PeteightInfo> {

	@Override public boolean shouldMerge(PetsnapInfo baseInfo, PeteightInfo selectedInfo) {
		return (baseInfo.codPeteight == selectedInfo.codPeteight);
	}
	
	
	
	@Override public List<PetsnapInfo> merge(PetsnapInfo baseInfo, PeteightInfo selectedInfo) {
		List<PetsnapInfo> results = new ArrayList<>();
		
		baseInfo.txtPeteightKg = selectedInfo.txtPeteightKg;
		
		results.add(baseInfo);
		return results;
	}
}
