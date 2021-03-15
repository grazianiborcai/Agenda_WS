package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;

final class StusoryrchVisiMergeStusorygrarch extends InfoMergerVisitorTemplate<StusoryrchInfo, StusorygrarchInfo> {

	@Override public boolean shouldMerge(StusoryrchInfo baseInfo, StusorygrarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser		);
	}
	
	
	
	@Override public List<StusoryrchInfo> merge(StusoryrchInfo baseInfo, StusorygrarchInfo selectedInfo) {
		List<StusoryrchInfo> results = new ArrayList<>();
		
		baseInfo.stusorygrarches.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
