package br.com.gda.payment.payOrderItem.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

final class PayordemCopyOrdmoip extends InfoCopierTemplate<PayordemInfo, OrdmoipInfo>{
	
	public PayordemCopyOrdmoip() {
		super();
	}
	
	
	
	@Override protected PayordemInfo makeCopyHook(OrdmoipInfo source) {
		PayordemInfo oneResult = source.payordemData;
		oneResult.ownId = source.ownId;
		oneResult.idOrderPartner = source.idOrderPartner;
		oneResult.statusOrderPartner = source.statusOrderPartner;	
		
		return oneResult;
	}
}
