package br.com.gda.payment.customer.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PaycusMergerToSelect extends InfoMergerTemplate<PaycusInfo, PaycusInfo> {

	@Override protected InfoMergerVisitorV2<PaycusInfo, PaycusInfo> getVisitorHook() {
		return new PaycusVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PaycusInfo> getUniquifierHook() {
		return new PaycusUniquifier();
	}
}
