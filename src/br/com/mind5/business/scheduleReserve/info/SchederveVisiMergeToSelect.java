package br.com.mind5.business.scheduleReserve.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class SchederveVisiMergeToSelect extends InfoMergerVisitorTemplate<SchederveInfo, SchederveInfo> {
	
	@Override public List<SchederveInfo> beforeMerge(List<SchederveInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchederveInfo baseInfo, SchederveInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchederveInfo> merge(SchederveInfo baseInfo, SchederveInfo selectedInfo) {
		List<SchederveInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchederveInfo> getUniquifier() {
		return null;
	}
}
