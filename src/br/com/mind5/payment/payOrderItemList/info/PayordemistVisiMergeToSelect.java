package br.com.mind5.payment.payOrderItemList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PayordemistVisiMergeToSelect extends InfoMergerVisitorTemplate<PayordemistInfo, PayordemistInfo> {
	
	@Override public List<PayordemistInfo> beforeMerge(List<PayordemistInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordemistInfo baseInfo, PayordemistInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PayordemistInfo> merge(PayordemistInfo baseInfo, PayordemistInfo selectedInfo) {
		List<PayordemistInfo> results = new ArrayList<>();
		
		selectedInfo.username = baseInfo.username;
		selectedInfo.codLanguage = baseInfo.codLanguage;
		
		results.add(selectedInfo);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordemistInfo> getUniquifier() {
		return null;
	}
}
