package br.com.mind5.payment.statusPayOrderItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

final class PaytusemMergerPayordem extends InfoMergerTemplate<PaytusemInfo, PayordemInfo> {

	@Override protected InfoMergerVisitor<PaytusemInfo, PayordemInfo> getVisitorHook() {
		return new PaytusemVisiMergePayordem();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusemInfo> getUniquifierHook() {
		return new PaytusemUniquifier();
	}
}
