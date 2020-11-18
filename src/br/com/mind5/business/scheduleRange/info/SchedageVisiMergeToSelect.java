package br.com.mind5.business.scheduleRange.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class SchedageVisiMergeToSelect extends InfoMergerVisitorTemplate<SchedageInfo, SchedageInfo> {
	
	@Override public List<SchedageInfo> beforeMerge(List<SchedageInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedageInfo baseInfo, SchedageInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedageInfo> merge(SchedageInfo baseInfo, SchedageInfo selectedInfo) {
		List<SchedageInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.dateValidFrom = baseInfo.dateValidFrom;
		selectedInfo.dateValidTo = baseInfo.dateValidTo;
		selectedInfo.timeValidFrom = baseInfo.timeValidFrom;
		selectedInfo.timeValidTo = baseInfo.timeValidTo;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedageInfo> getUniquifier() {
		return null;
	}
}
