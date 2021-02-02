package br.com.mind5.business.storeList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class StolisVisiMergeComplis extends InfoMergerVisitorTemplate<StolisInfo, ComplisInfo> {

	@Override public boolean shouldMerge(StolisInfo baseInfo, ComplisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<StolisInfo> merge(StolisInfo baseInfo, ComplisInfo selectedInfo) {
		List<StolisInfo> results = new ArrayList<>();
		
		baseInfo.complisData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<StolisInfo> uniquifyHook(List<StolisInfo> results) {
		InfoUniquifier<StolisInfo> uniquifier = new StolisUniquifier();		
		return uniquifier.uniquify(results);
	}
}
