package br.com.mind5.payment.payOrderItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class PayordemMergerStopar extends InfoMergerTemplate_<PayordemInfo, StoparInfo> {

	@Override protected InfoMergerVisitor_<PayordemInfo, StoparInfo> getVisitorHook() {
		return new PayordemVisiMergeStopar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordemInfo> getUniquifierHook() {
		return new PayordemUniquifier();
	}
}
