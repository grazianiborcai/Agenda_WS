package br.com.mind5.payment.payOrderItem.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.paymentPartner.partnerMoip.orderMoip.info.OrdmoipInfo;

final class PayordemCopyOrdmoip extends InfoCopierTemplate<PayordemInfo, OrdmoipInfo> {
	
	public PayordemCopyOrdmoip() {
		super();
	}
	
	
	
	@Override protected PayordemInfo makeCopyHook(OrdmoipInfo source) {
		PayordemInfo oneResult = source.payordemData;
		oneResult.ownId = source.ownId;
		oneResult.idOrderPartner = source.idOrderPartner;
		oneResult.statusOrderPartner = source.statusOrderPartner;	
		oneResult.idPaymentPartner = source.idPaymentPartner;
		oneResult.statusPaymentPartner = source.statusPaymentPartner;	
		
		return oneResult;
	}
}
