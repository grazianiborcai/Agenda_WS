package br.com.gda.payment.customer.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class PaycusMergerUsername extends InfoMergerTemplate<PaycusInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<PaycusInfo, UsernameInfo> getVisitorHook() {
		return new PaycusVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<PaycusInfo> getUniquifierHook() {
		return new PaycusUniquifier();
	}
}
