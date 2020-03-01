package br.com.mind5.payment.payOrderSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class PayordarchVisiMergeToSelect implements InfoMergerVisitorV3<PayordarchInfo, PayordarchInfo> {
	
	@Override public List<PayordarchInfo> beforeMerge(List<PayordarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordarchInfo baseInfo, PayordarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PayordarchInfo> merge(PayordarchInfo baseInfo, PayordarchInfo selectedInfo) {
		List<PayordarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordarchInfo> getUniquifier() {
		return null;
	}
}
