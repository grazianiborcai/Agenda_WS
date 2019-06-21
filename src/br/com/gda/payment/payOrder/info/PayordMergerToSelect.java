package br.com.gda.payment.payOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PayordMergerToSelect extends InfoMergerTemplate<PayordInfo, PayordInfo> {

	@Override protected InfoMergerVisitorV2<PayordInfo, PayordInfo> getVisitorHook() {
		return new PayordVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
