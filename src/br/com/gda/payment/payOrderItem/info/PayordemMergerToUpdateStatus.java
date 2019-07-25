package br.com.gda.payment.payOrderItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PayordemMergerToUpdateStatus extends InfoMergerTemplate<PayordemInfo, PayordemInfo> {

	@Override protected InfoMergerVisitorV2<PayordemInfo, PayordemInfo> getVisitorHook() {
		return new PayordemVisiMergeToUpdateStatus();
	}
	
	
	
	@Override protected InfoUniquifier<PayordemInfo> getUniquifierHook() {
		return new PayordemUniquifier();
	}
}
