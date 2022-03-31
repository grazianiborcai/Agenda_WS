package br.com.mind5.business.scheduleYear.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.scheduleYearData.info.SchedyeratInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedyearMergerVisiSchedyerat extends InfoMergerVisitorTemplate<SchedyearInfo, SchedyeratInfo> {

	@Override public boolean shouldMerge(SchedyearInfo baseInfo, SchedyeratInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codStore == selectedInfo.codStore &&
				baseInfo.year     == selectedInfo.year			);
	}
	
	
	
	@Override public List<SchedyearInfo> merge(SchedyearInfo baseInfo, SchedyeratInfo selectedInfo) {
		List<SchedyearInfo> results = new ArrayList<>();
		
		baseInfo.schedyerates.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
