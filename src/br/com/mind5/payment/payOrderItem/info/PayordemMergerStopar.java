package br.com.mind5.payment.payOrderItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class PayordemMergerStopar extends InfoMergerTemplate<PayordemInfo, StoparInfo> {

	@Override protected InfoMergerVisitor<PayordemInfo, StoparInfo> getVisitorHook() {
		return new PayordemVisiMergeStopar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordemInfo> getUniquifierHook() {
		return new PayordemUniquifier();
	}
}
