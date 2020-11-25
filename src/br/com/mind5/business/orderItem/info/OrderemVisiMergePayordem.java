package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class OrderemVisiMergePayordem extends InfoMergerVisitorTemplate<OrderemInfo, PayordemInfo> {

	@Override public boolean shouldMerge(OrderemInfo baseInfo, PayordemInfo selectedInfo) {
		return (baseInfo.codOwner    		== selectedInfo.codOwner 		&&
				baseInfo.codOrder    		== selectedInfo.codOrder 		&&
				baseInfo.codOrderItem   	== selectedInfo.codOrderItem 	&&
				baseInfo.codPayOrder 		== selectedInfo.codPayOrder		&&
				baseInfo.codPayOrderItem 	== selectedInfo.codPayOrderItem		);
	}
	
	

	@Override public List<OrderemInfo> merge(OrderemInfo baseInfo, PayordemInfo selectedInfo) {
		List<OrderemInfo> results = new ArrayList<>();
		
		//baseInfo.codPayPartner = selectedInfo.codPayPartner;
		baseInfo.statusOrderPartner = selectedInfo.statusOrderPartner;
		baseInfo.statusPaymentPartner = selectedInfo.statusPaymentPartner;
		
		results.add(baseInfo);
		return results;
	}
}
