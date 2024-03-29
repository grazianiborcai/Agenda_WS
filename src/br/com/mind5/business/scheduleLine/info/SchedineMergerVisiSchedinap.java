package br.com.mind5.business.scheduleLine.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedineMergerVisiSchedinap extends InfoMergerVisitorTemplate<SchedineInfo, SchedinapInfo> {

	@Override public boolean shouldMerge(SchedineInfo baseInfo, SchedinapInfo selectedInfo) {
		return (baseInfo.codOwner 	  == selectedInfo.codOwner 	&& 
				baseInfo.codSchedule  == selectedInfo.codSchedule		);
	}
	
	
	
	@Override public List<SchedineInfo> merge(SchedineInfo baseInfo, SchedinapInfo selectedInfo) {
		List<SchedineInfo> results = new ArrayList<>();
		
		baseInfo.codSnapshot = selectedInfo.codSnapshot;
		
		results.add(baseInfo);
		return results;
	}
}
