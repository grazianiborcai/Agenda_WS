package br.com.mind5.business.companyList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class ComplisVisiMergeToSelect implements InfoMergerVisitor<ComplisInfo, ComplisInfo> {
	
	@Override public List<ComplisInfo> beforeMerge(List<ComplisInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<ComplisInfo> getUniquifier() {
		return null;
	}
}
