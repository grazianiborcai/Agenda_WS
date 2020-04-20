package br.com.mind5.business.companyList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class ComplisVisiMergeComparch implements InfoMergerVisitorV3<ComplisInfo, ComparchInfo> {
	
	@Override public List<ComplisInfo> beforeMerge(List<ComplisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(ComplisInfo baseInfo, ComparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<ComplisInfo> merge(ComplisInfo baseInfo, ComparchInfo selectedInfo) {
		List<ComplisInfo> results = new ArrayList<>();
		
		ComplisInfo result = ComplisInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<ComplisInfo> getUniquifier() {
		return null;
	}
}
