package br.com.mind5.payment.creditCardSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CrecarchVisiMergeToSelect implements InfoMergerVisitor<CrecarchInfo, CrecarchInfo> {
	
	@Override public List<CrecarchInfo> beforeMerge(List<CrecarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CrecarchInfo baseInfo, CrecarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CrecarchInfo> merge(CrecarchInfo baseInfo, CrecarchInfo selectedInfo) {
		List<CrecarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CrecarchInfo> getUniquifier() {
		return null;
	}
}
