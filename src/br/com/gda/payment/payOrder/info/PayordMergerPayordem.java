package br.com.gda.payment.payOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.payOrderItem.info.PayordemInfo;

final class PayordMergerPayordem extends InfoMergerTemplate<PayordInfo, PayordemInfo> {

	@Override protected InfoMergerVisitorV2<PayordInfo, PayordemInfo> getVisitorHook() {
		return new PayordVisiMergePayordem();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
