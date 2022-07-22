package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class OrdmoipMergerVisiPayordem extends InfoMergerVisitorTemplate<OrdmoipInfo, PayordemInfo> {

	@Override public boolean shouldMerge(OrdmoipInfo baseInfo, PayordemInfo selectedInfo) {
		return (baseInfo.codOwner    	 == selectedInfo.codOwner 		&&
				baseInfo.codPayOrder 	 == selectedInfo.codPayOrder	&&
				baseInfo.codPayOrderItem == selectedInfo.codPayOrderItem	);
	}
	
	
	
	@Override public List<OrdmoipInfo> merge(OrdmoipInfo baseInfo, PayordemInfo selectedInfo) {
		List<OrdmoipInfo> results = new ArrayList<>();
		
		baseInfo.payordemData = selectedInfo;
		
		results.add(baseInfo);
		return results;
	}
}
