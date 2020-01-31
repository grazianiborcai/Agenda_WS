package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class PayordMergerPayordem extends InfoMergerTemplate_<PayordInfo, PayordemInfo> {

	@Override protected InfoMergerVisitor_<PayordInfo, PayordemInfo> getVisitorHook() {
		return new PayordVisiMergePayordem();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
