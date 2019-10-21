package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PayordMergerToUpdate extends InfoMergerTemplate<PayordInfo, PayordInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, PayordInfo> getVisitorHook() {
		return new PayordVisiMergeToUpdateStatus();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
