package br.com.gda.payment.payOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PayordMergerLatest extends InfoMergerTemplate<PayordInfo, PayordInfo> {

	@Override protected InfoMergerVisitorV2<PayordInfo, PayordInfo> getVisitorHook() {
		return new PayordVisiMergeLatest();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
