package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PayordVisiMergeToSelect extends InfoMergerVisitorTemplate<PayordInfo, PayordInfo> {
	
	@Override public List<PayordInfo> beforeMerge(List<PayordInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordInfo baseInfo, PayordInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, PayordInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordInfo> getUniquifier() {
		return new PayordUniquifier();
	}
}
