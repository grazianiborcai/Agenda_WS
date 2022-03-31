package br.com.mind5.business.scheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;

final class SchedayMergerVisiSchedatus extends InfoMergerVisitorTemplate<SchedayInfo, SchedatusInfo> {

	@Override public boolean shouldMerge(SchedayInfo baseInfo, SchedatusInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedayInfo> merge(SchedayInfo baseInfo, SchedatusInfo selectedInfo) {
		List<SchedayInfo> results = new ArrayList<>();
		
		baseInfo.schedatuses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
