package br.com.mind5.payment.payOrderSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PayordarchMergerToSelect extends InfoMergerTemplate<PayordarchInfo, PayordarchInfo> {

	@Override protected InfoMergerVisitor<PayordarchInfo, PayordarchInfo> getVisitorHook() {
		return new PayordarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PayordarchInfo> getUniquifierHook() {
		return new PayordarchUniquifier();
	}
}
