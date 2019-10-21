package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class PayordMergerUsername extends InfoMergerTemplate<PayordInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, UsernameInfo> getVisitorHook() {
		return new PayordVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
