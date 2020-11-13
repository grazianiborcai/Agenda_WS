package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;

final class SchedineVisiMergeSchedatus implements InfoMergerVisitor<SchedineInfo, SchedatusInfo> {
	
	@Override public List<SchedineInfo> beforeMerge(List<SchedineInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedineInfo baseInfo, SchedatusInfo selectedInfo) {
		if (baseInfo.codScheduleStatus  == null ||
			baseInfo.codLanguage		== null ||
			baseInfo.codScheduleStatus  == null ||
			baseInfo.codLanguage		== null 	)
			
			return false;					
			
			
			return (baseInfo.codScheduleStatus.equals(selectedInfo.codScheduleStatus) && 
					baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, SchedatusInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.txtScheduleStatus = selectedInfo.txtScheduleStatus;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedineInfo> getUniquifier() {
		return null;
	}
}
