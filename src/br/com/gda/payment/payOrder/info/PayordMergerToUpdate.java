package br.com.gda.payment.payOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PayordMergerToUpdate extends InfoMergerTemplate<PayordInfo, PayordInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, PayordInfo> getVisitorHook() {
		return new PayordVisiMergeToUpdateStatus();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
