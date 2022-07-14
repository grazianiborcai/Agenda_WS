package br.com.mind5.stats.statsUserOrderYear.userOrderYear.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;

final class StusoryMergerVisiStusorygr extends InfoMergerVisitorTemplate<StusoryInfo, StusorygrInfo> {

	@Override public boolean shouldMerge(StusoryInfo baseInfo, StusorygrInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codUser     == selectedInfo.codUser  &&
				baseInfo.postingYear == selectedInfo.postingYear);
	}
	
	
	
	@Override public List<StusoryInfo> merge(StusoryInfo baseInfo, StusorygrInfo selectedInfo) {
		List<StusoryInfo> results = new ArrayList<>();
		StusoryInfo result;
		
		result = StusoryInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
