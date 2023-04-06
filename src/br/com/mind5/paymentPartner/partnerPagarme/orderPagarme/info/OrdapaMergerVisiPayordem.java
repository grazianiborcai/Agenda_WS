package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class OrdapaMergerVisiPayordem extends InfoMergerVisitorTemplate<OrdapaInfo, PayordemInfo> {

	@Override public boolean shouldMerge(OrdapaInfo baseInfo, PayordemInfo selectedInfo) {
		return (baseInfo.codOwner        == selectedInfo.codOwner    &&
				baseInfo.codPayOrder     == selectedInfo.codPayOrder &&
				baseInfo.codPayOrderItem == selectedInfo.codPayOrderItem);
	}
	
	
	
	@Override public List<OrdapaInfo> merge(OrdapaInfo baseInfo, PayordemInfo selectedInfo) {
		List<OrdapaInfo> results = new ArrayList<>();
		
		baseInfo.payordemData = selectedInfo;	
		
		results.add(baseInfo);
		return results;
	}
}
