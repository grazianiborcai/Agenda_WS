package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class PayordMergerUsername extends InfoMergerTemplate_<PayordInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<PayordInfo, UsernameInfo> getVisitorHook() {
		return new PayordVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
