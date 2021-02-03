package br.com.mind5.business.scheduleWeek.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedeekVisiMergeMatlis extends InfoMergerVisitorTemplate<SchedeekInfo, MatlisInfo> {

	@Override public boolean shouldMerge(SchedeekInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner		);
	}
	
	
	
	@Override public List<SchedeekInfo> merge(SchedeekInfo baseInfo, MatlisInfo selectedInfo) {
		List<SchedeekInfo> results = new ArrayList<>();
		
		baseInfo.matlises.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
