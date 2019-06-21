package br.com.gda.payment.payOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class PayordMergerUsername extends InfoMergerTemplate<PayordInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<PayordInfo, UsernameInfo> getVisitorHook() {
		return new PayordVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
