package br.com.mind5.business.order.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;

final class OrderVisiMergePayord extends InfoMergerVisitorTemplate<OrderInfo, PayordInfo> {

	@Override public boolean shouldMerge(OrderInfo baseInfo, PayordInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner &&
				baseInfo.codOrder    == selectedInfo.codOrder &&
				baseInfo.codPayOrder == selectedInfo.codPayOrder);
	}
	
	

	@Override public List<OrderInfo> merge(OrderInfo baseInfo, PayordInfo selectedInfo) {
		List<OrderInfo> results = new ArrayList<>();
		
		baseInfo.codPayPartner = selectedInfo.codPayPartner;
		baseInfo.statusOrderPartner = selectedInfo.statusOrderPartner;
		baseInfo.statusPaymentPartner = selectedInfo.statusPaymentPartner;
		
		results.add(baseInfo);
		return results;
	}
}
