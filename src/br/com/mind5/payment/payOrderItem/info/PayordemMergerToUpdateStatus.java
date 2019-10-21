package br.com.mind5.payment.payOrderItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PayordemMergerToUpdateStatus extends InfoMergerTemplate<PayordemInfo, PayordemInfo> {

	@Override protected InfoMergerVisitor<PayordemInfo, PayordemInfo> getVisitorHook() {
		return new PayordemVisiMergeToUpdateStatus();
	}
	
	
	
	@Override protected InfoUniquifier<PayordemInfo> getUniquifierHook() {
		return new PayordemUniquifier();
	}
}
