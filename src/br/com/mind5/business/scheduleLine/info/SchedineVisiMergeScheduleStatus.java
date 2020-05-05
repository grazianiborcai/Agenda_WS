package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SchedineVisiMergeScheduleStatus implements InfoMergerVisitorV3<SchedineInfo, ScheduleStatusInfo> {
	
	@Override public List<SchedineInfo> beforeMerge(List<SchedineInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedineInfo baseInfo, ScheduleStatusInfo selectedInfo) {
		if (baseInfo.codScheduleStatus  == null ||
			baseInfo.codLanguage		== null ||
			baseInfo.codScheduleStatus  == null ||
			baseInfo.codLanguage		== null 	)
			
			return false;					
			
			
			return (baseInfo.codScheduleStatus.equals(selectedInfo.codScheduleStatus) && 
					baseInfo.codLanguage.equals(selectedInfo.codLanguage));
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, ScheduleStatusInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.txtScheduleStatus = selectedInfo.txtScheduleStatus;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedineInfo> getUniquifier() {
		return null;
	}
}
