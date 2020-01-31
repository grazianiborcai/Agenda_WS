package br.com.mind5.payment.payOrderItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PayordemMergerToSelect extends InfoMergerTemplate_<PayordemInfo, PayordemInfo> {

	@Override protected InfoMergerVisitor_<PayordemInfo, PayordemInfo> getVisitorHook() {
		return new PayordemVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PayordemInfo> getUniquifierHook() {
		return new PayordemUniquifier();
	}
}
