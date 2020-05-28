package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SchedeekVisiMergeEmplis implements InfoMergerVisitorV3<SchedeekInfo, EmplisInfo> {
	
	@Override public List<SchedeekInfo> beforeMerge(List<SchedeekInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedeekInfo baseInfo, EmplisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, EmplisInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.emplises.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedeekInfo> getUniquifier() {
		return null;
	}
}
