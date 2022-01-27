package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petList.info.PetlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedineVisiMergePetlis extends InfoMergerVisitorTemplate<SchedineInfo, PetlisInfo> {

	@Override public boolean shouldMerge(SchedineInfo baseInfo, PetlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner && 
				baseInfo.codPet   == selectedInfo.codPet		);
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, PetlisInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.petlisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
