package br.com.mind5.business.personBio.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PerbioMergerVisiToSelect extends InfoMergerVisitorTemplate<PerbioInfo, PerbioInfo> {

	@Override public boolean shouldMerge(PerbioInfo baseInfo, PerbioInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PerbioInfo> merge(PerbioInfo baseInfo, PerbioInfo selectedInfo) {
		List<PerbioInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
