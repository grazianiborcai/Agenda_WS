package br.com.gda.payment.payOrderSearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PayordarchMergerToSelect extends InfoMergerTemplate<PayordarchInfo, PayordarchInfo> {

	@Override protected InfoMergerVisitor<PayordarchInfo, PayordarchInfo> getVisitorHook() {
		return new PayordarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PayordarchInfo> getUniquifierHook() {
		return new PayordarchUniquifier();
	}
}
