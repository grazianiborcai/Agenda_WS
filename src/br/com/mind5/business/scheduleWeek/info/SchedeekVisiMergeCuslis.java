package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class SchedeekVisiMergeCuslis implements InfoMergerVisitorV3<SchedeekInfo, CuslisInfo> {
	
	@Override public List<SchedeekInfo> beforeMerge(List<SchedeekInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(SchedeekInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, CuslisInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.cuslises.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<SchedeekInfo> getUniquifier() {
		return null;
	}
}
