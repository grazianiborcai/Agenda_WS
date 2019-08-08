package br.com.gda.payment.payOrderItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.storePartner.info.StoparInfo;

final class PayordemMergerStopar extends InfoMergerTemplate<PayordemInfo, StoparInfo> {

	@Override protected InfoMergerVisitor<PayordemInfo, StoparInfo> getVisitorHook() {
		return new PayordemVisiMergeStopar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordemInfo> getUniquifierHook() {
		return new PayordemUniquifier();
	}
}
