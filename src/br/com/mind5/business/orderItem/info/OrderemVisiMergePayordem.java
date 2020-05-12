package br.com.mind5.business.orderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorV3;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class OrderemVisiMergePayordem implements InfoMergerVisitorV3<OrderemInfo, PayordemInfo> {

	@Override public List<OrderemInfo> beforeMerge(List<OrderemInfo> baseInfos) {
		return baseInfos;
	}
	
	
	
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
	
	
	
	@Override public InfoUniquifier<OrderemInfo> getUniquifier() {
		return null;
	}
}
