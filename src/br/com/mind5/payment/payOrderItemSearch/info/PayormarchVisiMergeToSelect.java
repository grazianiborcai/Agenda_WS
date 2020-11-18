package br.com.mind5.payment.payOrderItemSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PayormarchVisiMergeToSelect extends InfoMergerVisitorTemplate<PayormarchInfo, PayormarchInfo> {
	
	@Override public List<PayormarchInfo> beforeMerge(List<PayormarchInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayormarchInfo baseInfo, PayormarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PayormarchInfo> merge(PayormarchInfo baseInfo, PayormarchInfo selectedInfo) {
		List<PayormarchInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayormarchInfo> getUniquifier() {
		return null;
	}
}
