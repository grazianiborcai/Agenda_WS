package br.com.mind5.business.scheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedmonMergerVisiStolis extends InfoMergerVisitorTemplate<SchedmonInfo, StolisInfo> {

	@Override public boolean shouldMerge(SchedmonInfo baseInfo, StolisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedmonInfo> merge(SchedmonInfo baseInfo, StolisInfo selectedInfo) {
		List<SchedmonInfo> results = new ArrayList<>();
		
		baseInfo.stolises.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
