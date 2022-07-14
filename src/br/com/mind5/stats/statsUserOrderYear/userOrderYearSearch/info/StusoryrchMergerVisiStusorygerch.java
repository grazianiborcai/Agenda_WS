package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;

final class StusoryrchMergerVisiStusorygerch extends InfoMergerVisitorTemplate<StusoryrchInfo, StusorygerchInfo> {

	@Override public boolean shouldMerge(StusoryrchInfo baseInfo, StusorygerchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser);
	}
	
	
	
	@Override public List<StusoryrchInfo> merge(StusoryrchInfo baseInfo, StusorygerchInfo selectedInfo) {
		List<StusoryrchInfo> results = new ArrayList<>();
		
		baseInfo.stusorygerches.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
