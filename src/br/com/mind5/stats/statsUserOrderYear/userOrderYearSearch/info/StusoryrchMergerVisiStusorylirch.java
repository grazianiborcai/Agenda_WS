package br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;

final class StusoryrchMergerVisiStusorylirch extends InfoMergerVisitorTemplate<StusoryrchInfo, StusorylirchInfo> {

	@Override public boolean shouldMerge(StusoryrchInfo baseInfo, StusorylirchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner &&
				baseInfo.codUser  == selectedInfo.codUser);
	}
	
	
	
	@Override public List<StusoryrchInfo> merge(StusoryrchInfo baseInfo, StusorylirchInfo selectedInfo) {
		List<StusoryrchInfo> results = new ArrayList<>();
		
		baseInfo.stusorylirches.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
