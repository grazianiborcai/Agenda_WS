package br.com.mind5.business.scheduleLineSnapshot.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedinapMergerVisiToSelect extends InfoMergerVisitorTemplate<SchedinapInfo, SchedinapInfo> {

	@Override public boolean shouldMerge(SchedinapInfo baseInfo, SchedinapInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedinapInfo> merge(SchedinapInfo baseInfo, SchedinapInfo selectedInfo) {
		List<SchedinapInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
