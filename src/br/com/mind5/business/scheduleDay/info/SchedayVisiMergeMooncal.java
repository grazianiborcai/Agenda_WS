package br.com.mind5.business.scheduleDay.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.moonCalendar.info.MooncalInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SchedayVisiMergeMooncal implements InfoMergerVisitorV3<SchedayInfo, MooncalInfo> {
	
	@Override public List<SchedayInfo> beforeMerge(List<SchedayInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedayInfo baseInfo, MooncalInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<SchedayInfo> merge(SchedayInfo baseInfo, MooncalInfo selectedInfo) {
		List<SchedayInfo> results = new ArrayList<>();
		
		baseInfo.mooncales.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedayInfo> getUniquifier() {
		return null;
	}
}
