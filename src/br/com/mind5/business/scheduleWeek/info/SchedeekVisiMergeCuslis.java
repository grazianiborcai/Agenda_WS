package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedeekVisiMergeCuslis extends InfoMergerVisitorTemplate<SchedeekInfo, CuslisInfo> {

	@Override public boolean shouldMerge(SchedeekInfo baseInfo, CuslisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, CuslisInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.cuslises.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
