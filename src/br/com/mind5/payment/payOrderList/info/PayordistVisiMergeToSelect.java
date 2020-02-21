package br.com.mind5.payment.payOrderList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;

final class PayordistVisiMergeToSelect implements InfoMergerVisitorV3<PayordistInfo, PayordistInfo> {
	
	@Override public List<PayordistInfo> beforeMerge(List<PayordistInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordistInfo baseInfo, PayordistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PayordistInfo> merge(PayordistInfo baseInfo, PayordistInfo selectedInfo) {
		List<PayordistInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordistInfo> getUniquifier() {
		return null;
	}
}
