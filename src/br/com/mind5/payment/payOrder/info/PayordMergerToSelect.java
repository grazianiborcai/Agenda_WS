package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PayordMergerToSelect extends InfoMergerTemplate_<PayordInfo, PayordInfo> {

	@Override protected InfoMergerVisitor_<PayordInfo, PayordInfo> getVisitorHook() {
		return new PayordVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
