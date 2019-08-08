package br.com.gda.payment.payOrderItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PayordemMergerToSelect extends InfoMergerTemplate<PayordemInfo, PayordemInfo> {

	@Override protected InfoMergerVisitor<PayordemInfo, PayordemInfo> getVisitorHook() {
		return new PayordemVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PayordemInfo> getUniquifierHook() {
		return new PayordemUniquifier();
	}
}
