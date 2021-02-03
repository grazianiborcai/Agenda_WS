package br.com.mind5.payment.payOrderList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;

final class PayordistVisiMergeToSelect extends InfoMergerVisitorTemplate<PayordistInfo, PayordistInfo> {

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
}
