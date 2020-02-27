package br.com.mind5.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

final class PayordemVisiMergePayormarch implements InfoMergerVisitorV3<PayordemInfo, PayormarchInfo> {
	
	@Override public List<PayordemInfo> beforeMerge(List<PayordemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
	@Override public boolean shouldMerge(PayordemInfo baseInfo, PayormarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<PayordemInfo> merge(PayordemInfo baseInfo, PayormarchInfo selectedInfo) {
		List<PayordemInfo> results = new ArrayList<>();
		
		PayordemInfo result = PayordemInfo.copyFrom(selectedInfo); 
		
		results.add(result);
		return results;
	}
	
	
	
	@Override public InfoUniquifier<PayordemInfo> getUniquifier() {
		return null;
	}
}
