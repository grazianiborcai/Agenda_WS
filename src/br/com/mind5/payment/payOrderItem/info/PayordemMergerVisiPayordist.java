package br.com.mind5.payment.payOrderItem.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

final class PayordemMergerVisiPayordist extends InfoMergerVisitorTemplate<PayordemInfo, PayordistInfo> {

	@Override public boolean shouldMerge(PayordemInfo baseInfo, PayordistInfo selectedInfo) {
		return (baseInfo.codOwner	  == selectedInfo.codOwner	&&
				baseInfo.codPayOrder  == selectedInfo.codPayOrder);
	}
	
	
	
	@Override public List<PayordemInfo> merge(PayordemInfo baseInfo, PayordistInfo selectedInfo) {
		List<PayordemInfo> results = new ArrayList<>();
		
		baseInfo.codPayPartner = selectedInfo.codPayPartner; 
		
		results.add(baseInfo);
		return results;
	}
}
