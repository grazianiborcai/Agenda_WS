package br.com.mind5.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

final class PayordemVisiMergePayormarch extends InfoMergerVisitorTemplate<PayordemInfo, PayormarchInfo> {

	@Override public boolean shouldMerge(PayordemInfo baseInfo, PayormarchInfo selectedInfo) {
		return true;
	}
	
	
	
	@Override public List<PayordemInfo> merge(PayordemInfo baseInfo, PayormarchInfo selectedInfo) {
		List<PayordemInfo> results = new ArrayList<>();
		
		PayordemInfo result = PayordemInfo.copyFrom(selectedInfo); 
		
		results.add(result);
		return results;
	}
}
