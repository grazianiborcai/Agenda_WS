package br.com.mind5.business.companyList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;

final class ComplisMergerVisiComparch extends InfoMergerVisitorTemplate<ComplisInfo, ComparchInfo> {

	@Override public boolean shouldMerge(ComplisInfo baseInfo, ComparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<ComplisInfo> merge(ComplisInfo baseInfo, ComparchInfo selectedInfo) {
		List<ComplisInfo> results = new ArrayList<>();
		
		ComplisInfo result = ComplisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
