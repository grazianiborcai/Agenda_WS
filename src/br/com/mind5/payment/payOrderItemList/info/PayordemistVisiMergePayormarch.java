package br.com.mind5.payment.payOrderItemList.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

final class PayordemistVisiMergePayormarch extends InfoMergerVisitorTemplate<PayordemistInfo, PayormarchInfo> {
	
	@Override public List<PayordemistInfo> beforeMerge(List<PayordemistInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordemistInfo baseInfo, PayormarchInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner);
	}
	
	
	
	@Override public List<PayordemistInfo> merge(PayordemistInfo baseInfo, PayormarchInfo selectedInfo) {
		List<PayordemistInfo> results = new ArrayList<>();
		
		PayordemistInfo result = PayordemistInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordemistInfo> getUniquifier() {
		return null;
	}
}
