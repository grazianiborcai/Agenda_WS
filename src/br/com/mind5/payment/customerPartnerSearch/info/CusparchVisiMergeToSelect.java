package br.com.mind5.payment.customerPartnerSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class CusparchVisiMergeToSelect implements InfoMergerVisitorV3<CusparchInfo, CusparchInfo> {
	
	@Override public List<CusparchInfo> beforeMerge(List<CusparchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(CusparchInfo baseInfo, CusparchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<CusparchInfo> merge(CusparchInfo baseInfo, CusparchInfo selectedInfo) {
		List<CusparchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<CusparchInfo> getUniquifier() {
		return null;
	}
}
