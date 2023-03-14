package br.com.mind5.payment.payOrder.info;

import java.util.ArrayList;
import java.util.List;

import br.com.mind5.info.InfoMergerVisitorTemplate;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;
import br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info.OrdapaInfo;

final class PayordMergerVisiOrdapa extends InfoMergerVisitorTemplate<PayordInfo, OrdapaInfo> {

	@Override public boolean shouldMerge(PayordInfo baseInfo, OrdapaInfo selectedInfo) {
		return (baseInfo.codOwner 	 == selectedInfo.codOwner	 &&
				baseInfo.codPayOrder == selectedInfo.codPayOrder	);
	}
	
	
	
	@Override public List<PayordInfo> merge(PayordInfo baseInfo, OrdapaInfo selectedInfo) {
		List<PayordInfo> results = new ArrayList<>();
/*		
		baseInfo.idOrderPartner = selectedInfo.idOrderPartner;
		baseInfo.statusOrderPartner = selectedInfo.statusOrderPartner;
		baseInfo.idPaymentPartner = selectedInfo.idPaymentPartner;
		baseInfo.statusPaymentPartner = selectedInfo.statusPaymentPartner;
		baseInfo.amountTotalPartner = selectedInfo.amountTotalPartner;
		baseInfo.amountCurrencyPartner = selectedInfo.amountCurrencyPartner;
		baseInfo.ownId = selectedInfo.ownId;
		
		baseInfo = mergePayordem(baseInfo, selectedInfo.ordmoips);
*/		
		results.add(baseInfo);
		return results;
	}
	
	
	
	private PayordInfo mergePayordem(PayordInfo baseInfo, List<OrdmoipInfo> ordmoips) {
		for (OrdmoipInfo eachMoip : ordmoips) {
			for (PayordemInfo eachPayordem : baseInfo.payordems) {
				if (eachMoip.codOwner 		 == eachPayordem.codOwner 		&&
					eachMoip.codPayOrder 	 == eachPayordem.codPayOrder 	&&
					eachMoip.codPayOrderItem == eachPayordem.codPayOrderItem	) {
					
					eachPayordem.idOrderPartner = eachMoip.idOrderPartner;
					eachPayordem.statusOrderPartner = eachMoip.statusOrderPartner;	
					eachPayordem.idPaymentPartner = eachMoip.idPaymentPartner;
					eachPayordem.statusPaymentPartner = eachMoip.statusPaymentPartner;	
					eachPayordem.itemReceiver = eachMoip.itemReceiver;
					eachPayordem.ownId = eachMoip.ownId;					
				}
			}
		}
		
		return baseInfo;
	}
	
	
	
	@Override public List<PayordInfo> uniquifyHook(List<PayordInfo> results) {
		InfoUniquifier<PayordInfo> uniquifier = new PayordUniquifier();		
		return uniquifier.uniquify(results);
	}
}
