package br.com.gda.payment.payOrderItemStatus.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

final class PaytusemMergerPayordem extends InfoMergerTemplate<PaytusemInfo, PayordemInfo> {

	@Override protected InfoMergerVisitorV2<PaytusemInfo, PayordemInfo> getVisitorHook() {
		return new PaytusemVisiMergePayordem();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusemInfo> getUniquifierHook() {
		return new PaytusemUniquifier();
	}
}
