package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class SchedineVisiMergeSchedauth extends InfoMergerVisitorTemplate<SchedineInfo, SchedauthInfo> {
	
	@Override public List<SchedineInfo> beforeMerge(List<SchedineInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedineInfo baseInfo, SchedauthInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, SchedauthInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.codStore = selectedInfo.codStore;
		baseInfo.codUser = selectedInfo.codUser;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedineInfo> getUniquifier() {
		return null;
	}
}
