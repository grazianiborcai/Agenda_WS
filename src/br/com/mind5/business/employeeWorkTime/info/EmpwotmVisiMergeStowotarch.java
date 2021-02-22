package br.com.mind5.business.employeeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoMergerCardinality;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class EmpwotmVisiMergeStowotarch extends InfoMergerVisitorTemplate<EmpwotmInfo, StowotarchInfo> {
	
	@Override public boolean shouldMerge(EmpwotmInfo baseInfo, StowotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codStore == selectedInfo.codStore		);
	}
	
	
	
	@Override public List<EmpwotmInfo> merge(EmpwotmInfo baseInfo, StowotarchInfo selectedInfo) {
		List<EmpwotmInfo> results = new ArrayList<>();
		
		baseInfo.codWeekday = selectedInfo.codWeekday;
		baseInfo.beginTime = selectedInfo.beginTime;
		baseInfo.endTime = selectedInfo.endTime;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override protected InfoMergerCardinality getCardinalityHook() {
		return InfoMergerCardinality.ONE_TO_MANY;
	}
}
