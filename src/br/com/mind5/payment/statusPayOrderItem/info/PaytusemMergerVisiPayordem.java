package br.com.mind5.payment.statusPayOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class PaytusemMergerVisiPayordem extends InfoMergerVisitorTemplate<PaytusemInfo, PayordemInfo> {

	@Override public boolean shouldMerge(PaytusemInfo baseInfo, PayordemInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner 	&&
				baseInfo.codPayOrder == selectedInfo.codPayOrder	);
	}
	
	
	
	@Override public List<PaytusemInfo> merge(PaytusemInfo baseInfo, PayordemInfo selectedInfo) {
		List<PaytusemInfo> results = new ArrayList<>();
		
		PaytusemInfo result = PaytusemInfo.copyFrom(selectedInfo);
		
		results.add(result);
		return results;
	}
}
