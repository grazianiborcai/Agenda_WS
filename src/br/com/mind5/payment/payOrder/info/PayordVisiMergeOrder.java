package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;

final class PayordVisiMergeOrder extends InfoMergerVisitorTemplate<PayordInfo, OrderInfo> {

	@Override public boolean shouldMerge(PayordInfo baseInfo, OrderInfo selectedInfo) {
		return (baseInfo.codOwner == selectedInfo.codOwner	&&
				baseInfo.codOrder == selectedInfo.codOrder);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, OrderInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
		
		baseInfo.orderData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	@Override public List<PayordInfo> uniquifyHook(List<PayordInfo> results) {
		InfoUniquifier<PayordInfo> uniquifier = new PayordUniquifier();		
		return uniquifier.uniquify(results);
	}
}
