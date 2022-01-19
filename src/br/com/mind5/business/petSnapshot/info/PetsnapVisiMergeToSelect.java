package br.com.mind5.business.petSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PetsnapVisiMergeToSelect extends InfoMergerVisitorTemplate<PetsnapInfo, PetsnapInfo> {

	@Override public boolean shouldMerge(PetsnapInfo baseInfo, PetsnapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PetsnapInfo> merge(PetsnapInfo baseInfo, PetsnapInfo selectedInfo) {
		List<PetsnapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
