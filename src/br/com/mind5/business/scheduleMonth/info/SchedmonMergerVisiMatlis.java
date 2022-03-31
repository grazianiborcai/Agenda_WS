package br.com.mind5.business.scheduleMonth.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class SchedmonMergerVisiMatlis extends InfoMergerVisitorTemplate<SchedmonInfo, MatlisInfo> {

	@Override public boolean shouldMerge(SchedmonInfo baseInfo, MatlisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<SchedmonInfo> merge(SchedmonInfo baseInfo, MatlisInfo selectedInfo) {
		List<SchedmonInfo> results = new ArrayList<>();
		
		baseInfo.matlises.add(selectedInfo);
		
		results.add(baseInfo);
		return results;
	}
}
