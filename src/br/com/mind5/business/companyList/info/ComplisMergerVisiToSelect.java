package br.com.mind5.business.companyList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class ComplisMergerVisiToSelect extends InfoMergerVisitorTemplate<ComplisInfo, ComplisInfo> {

	@Override public boolean shouldMerge(ComplisInfo baseInfo, ComplisInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<ComplisInfo> merge(ComplisInfo baseInfo, ComplisInfo selectedInfo) {
		List<ComplisInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
}
