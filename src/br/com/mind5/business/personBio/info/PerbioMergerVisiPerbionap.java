package br.com.mind5.business.personBio.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PerbioMergerVisiPerbionap extends InfoMergerVisitorTemplate<PerbioInfo, PerbionapInfo> {

	@Override public boolean shouldMerge(PerbioInfo baseInfo, PerbionapInfo selectedInfo) {
		return (baseInfo.codOwner  == selectedInfo.codOwner &&
				baseInfo.codPerson == selectedInfo.codPerson &&
				baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	

	@Override public List<PerbioInfo> merge(PerbioInfo baseInfo, PerbionapInfo selectedInfo) {
		List<PerbioInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
