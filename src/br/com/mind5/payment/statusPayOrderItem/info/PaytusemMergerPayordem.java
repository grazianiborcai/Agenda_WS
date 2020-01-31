package br.com.mind5.payment.statusPayOrderItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class PaytusemMergerPayordem extends InfoMergerTemplate_<PaytusemInfo, PayordemInfo> {

	@Override protected InfoMergerVisitor_<PaytusemInfo, PayordemInfo> getVisitorHook() {
		return new PaytusemVisiMergePayordem();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusemInfo> getUniquifierHook() {
		return new PaytusemUniquifier();
	}
}
