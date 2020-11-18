package br.com.mind5.business.materialList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class MatlisVisiMergeMatarch extends InfoMergerVisitorTemplate<MatlisInfo, MatarchInfo> {
	
	@Override public boolean shouldMerge(MatlisInfo baseInfo, MatarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<MatlisInfo> merge(MatlisInfo baseInfo, MatarchInfo selectedInfo) {
		List<MatlisInfo> results = new ArrayList<>();
		
		MatlisInfo result = MatlisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
