package br.com.mind5.payment.payOrderSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PayordarchMergerToSelect extends InfoMergerTemplate_<PayordarchInfo, PayordarchInfo> {

	@Override protected InfoMergerVisitor_<PayordarchInfo, PayordarchInfo> getVisitorHook() {
		return new PayordarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PayordarchInfo> getUniquifierHook() {
		return new PayordarchUniquifier();
	}
}
