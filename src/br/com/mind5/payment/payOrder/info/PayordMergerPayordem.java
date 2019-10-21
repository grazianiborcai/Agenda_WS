package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class PayordMergerPayordem extends InfoMergerTemplate<PayordInfo, PayordemInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, PayordemInfo> getVisitorHook() {
		return new PayordVisiMergePayordem();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
