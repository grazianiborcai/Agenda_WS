package br.com.mind5.business.personBio.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PerbioMergerVisiToUpdate extends InfoMergerVisitorTemplate<PerbioInfo, PerbioInfo> {

	@Override public boolean shouldMerge(PerbioInfo baseInfo, PerbioInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner 	&&
				baseInfo.codPerson == selectedInfo.codPerson 	&&
				baseInfo.username.equals(selectedInfo.username));
	}
	
	
	
	@Override public List<PerbioInfo> merge(PerbioInfo baseInfo, PerbioInfo selectedInfo) {
		List<PerbioInfo> results = new ArrayList<>();
		
		baseInfo.createdOn = selectedInfo.createdOn;
		baseInfo.createdBy = selectedInfo.createdBy;
		
		results.add(baseInfo);
		return results;
	}
}
