package br.com.mind5.business.scheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;

final class SchedayVisiMergeSchedatus extends InfoMergerVisitorTemplate<SchedayInfo, SchedatusInfo> {
	
	@Override public List<SchedayInfo> beforeMerge(List<SchedayInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedayInfo baseInfo, SchedatusInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedayInfo> merge(SchedayInfo baseInfo, SchedatusInfo selectedInfo) {
		List<SchedayInfo> results = new ArrayList<>();
		
		baseInfo.schedatuses.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedayInfo> getUniquifier() {
		return null;
	}
}
