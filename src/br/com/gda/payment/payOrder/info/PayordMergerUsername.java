package br.com.gda.payment.payOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class PayordMergerUsername extends InfoMergerTemplate<PayordInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, UsernameInfo> getVisitorHook() {
		return new PayordVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
