package br.com.mind5.business.personBioSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PerbiorchVisiMergeToSelect extends InfoMergerVisitorTemplate<PerbiorchInfo, PerbiorchInfo> {

	@Override public boolean shouldMerge(PerbiorchInfo baseInfo, PerbiorchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	

	@Override public List<PerbiorchInfo> merge(PerbiorchInfo baseInfo, PerbiorchInfo selectedInfo) {
		List<PerbiorchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
}
