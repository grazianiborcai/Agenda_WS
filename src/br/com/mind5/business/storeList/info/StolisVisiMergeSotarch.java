package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StolisVisiMergeSotarch extends InfoMergerVisitorTemplate<StolisInfo, SotarchInfo> {

	@Override public boolean shouldMerge(StolisInfo baseInfo, SotarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, SotarchInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		StolisInfo result = StolisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();		
		return uniquifier.uniquify(results);
	}
}
