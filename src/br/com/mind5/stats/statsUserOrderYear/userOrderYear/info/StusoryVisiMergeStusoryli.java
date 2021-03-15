package br.com.mind5.stats.statsUserOrderYear.userOrderYear.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLive.info.StusoryliInfo;

final class StusoryVisiMergeStusoryli extends InfoMergerVisitorTemplate<StusoryInfo, StusoryliInfo> {

	@Override public boolean shouldMerge(StusoryInfo baseInfo, StusoryliInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codUser     == selectedInfo.codUser  &&
				baseInfo.postingYear == selectedInfo.postingYear);
	}
	
	
	
	@Override public List<StusoryInfo> merge(StusoryInfo baseInfo, StusoryliInfo selectedInfo) {
		List<StusoryInfo> results = new ArrayList<>();
		StusoryInfo result;
		
		result = StusoryInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
