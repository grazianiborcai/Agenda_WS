package br.com.mind5.stats.statsUserOrderYear.userOrderYear.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearSearch.info.StusoryrchInfo;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;

final class StusoryMergerVisiStusoryrch extends InfoMergerVisitorTemplate<StusoryInfo, StusoryrchInfo> {

	@Override public boolean shouldMerge(StusoryInfo baseInfo, StusoryrchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StusoryInfo> merge(StusoryInfo baseInfo, StusoryrchInfo selectedInfo) {
		List<StusoryInfo> results = new ArrayList<>();
		
		results = mergeLive(results, selectedInfo.stusorylirches);
		results = mergeAggregated(results, selectedInfo.stusorygrarches);
		results = mergeStaging(results, selectedInfo.stusorygerches);
		
		return results;
	}
	
	
	
	private List<StusoryInfo> mergeLive(List<StusoryInfo> results, List<StusorylirchInfo> stusorylirches) {
		if (stusorylirches == null) 
			return results;
		
		if (stusorylirches.isEmpty()) 
			return results;
		
		for (StusorylirchInfo eachStusorylirch : stusorylirches) {
			StusoryInfo eachResult = StusoryInfo.copyFrom(eachStusorylirch);
			results.add(eachResult);
		}
		
		return results;
	}
	
	
	
	private List<StusoryInfo> mergeAggregated(List<StusoryInfo> results, List<StusorygrarchInfo> stusorygrarches) {
		if (stusorygrarches == null) 
			return results;
		
		if (stusorygrarches.isEmpty()) 
			return results;
		
		for (StusorygrarchInfo eachStusorygrarch : stusorygrarches) {
			StusoryInfo eachResult = StusoryInfo.copyFrom(eachStusorygrarch);
			results.add(eachResult);
		}
		
		return results;
	}
	
	
	
	private List<StusoryInfo> mergeStaging(List<StusoryInfo> results, List<StusorygerchInfo> stusorygerches) {
		if (stusorygerches == null) 
			return results;
		
		if (stusorygerches.isEmpty()) 
			return results;
		
		for (StusorygerchInfo eachStusorygerch : stusorygerches) {
			StusoryInfo eachResult = StusoryInfo.copyFrom(eachStusorygerch);
			results.add(eachResult);
		}
		
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
