package br.com.mind5.business.employeeWorkTime.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpwotmVisiMergeStowotarch implements InfoMergerVisitor<EmpwotmInfo, StowotarchInfo> {
	
	@Override public List<EmpwotmInfo> beforeMerge(List<EmpwotmInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(EmpwotmInfo baseInfo, StowotarchInfo selectedInfo) {
		return (baseInfo.codOwner   == selectedInfo.codOwner		&&
				baseInfo.codStore   == selectedInfo.codStore);
	}
	
	
	
	@Override public List<EmpwotmInfo> merge(EmpwotmInfo baseInfo, StowotarchInfo selectedInfo) {
		List<EmpwotmInfo> results = new ArrayList<>();
		
		baseInfo.codWeekday = selectedInfo.codWeekday;
		baseInfo.beginTime = selectedInfo.beginTime;
		baseInfo.endTime = selectedInfo.endTime;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<EmpwotmInfo> getUniquifier() {
		return null;
	}
}
