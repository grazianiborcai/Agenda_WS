package br.com.mind5.business.customer.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CusVisiMergeToSelect implements InfoMergerVisitor<CusInfo, CusInfo> {
	
	@Override public List<CusInfo> beforeMerge(List<CusInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusInfo baseInfo, CusInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusInfo> merge(CusInfo baseInfo, CusInfo selectedInfo) {
		List<CusInfo> results = new ArrayList<>();
		
		selectedInfo.codLanguage = baseInfo.codLanguage;
		selectedInfo.username = baseInfo.username;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusInfo> getUniquifier() {
		return null;
	}
}
