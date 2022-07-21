package br.com.mind5.payment.payOrderSearch.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PayordarchMergerVisiToSelect extends InfoMergerVisitorTemplate<PayordarchInfo, PayordarchInfo> {

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
}
