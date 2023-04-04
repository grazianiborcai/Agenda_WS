package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class OrdapaMergerVisiPayord extends InfoMergerVisitorTemplate<OrdapaInfo, PayordInfo> {

	@Override public boolean shouldMerge(OrdapaInfo baseInfo, PayordInfo selectedInfo) {
		return (baseInfo.codOwner    == selectedInfo.codOwner    &&
				baseInfo.codPayOrder == selectedInfo.codPayOrder);
	}
	
	
	
	@Override public List<OrdapaInfo> merge(OrdapaInfo baseInfo, PayordInfo selectedInfo) {
		List<OrdapaInfo> results = new ArrayList<>();
		
		baseInfo.payordData = filterItem(baseInfo, selectedInfo);	
		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private PayordInfo filterItem(OrdapaInfo baseInfo, PayordInfo selectedInfo) {
		if (selectedInfo.payordems == null)
			return selectedInfo;
		
		if (selectedInfo.payordems.isEmpty())
			return selectedInfo;
		
		
		List<PayordemInfo> payordems = new ArrayList<>();
		
		for(PayordemInfo eachPayordem : selectedInfo.payordems) {
			if ( eachPayordem.codOwner        == baseInfo.codOwner    &&
				 eachPayordem.codPayOrder     == baseInfo.codPayOrder &&
				 eachPayordem.codPayOrderItem == baseInfo.codPayOrderItem)
				
				payordems.add(eachPayordem);
		}
		
		
		selectedInfo.payordems = payordems;
		return selectedInfo;
	}
}
