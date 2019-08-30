package br.com.gda.payment.payOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;

final class PayordMergerLatest extends InfoMergerTemplate<PayordInfo, PayordarchInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, PayordarchInfo> getVisitorHook() {
		return new PayordVisiMergeLatest();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
