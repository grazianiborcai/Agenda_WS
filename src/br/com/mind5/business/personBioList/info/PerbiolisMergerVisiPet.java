package br.com.mind5.business.personBioList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PerbiolisMergerVisiPet extends InfoMergerVisitorTemplate<PerbiolisInfo, PerbioInfo> {

	@Override public boolean shouldMerge(PerbiolisInfo baseInfo, PerbioInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner &&
				baseInfo.codPerson == selectedInfo.codPerson);
	}
	
	
	
	@Override public List<PerbiolisInfo> merge(PerbiolisInfo baseInfo, PerbioInfo selectedInfo) {
		List<PerbiolisInfo> results = new ArrayList<>();
		PerbiolisInfo result = PerbiolisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
