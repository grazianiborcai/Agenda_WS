package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

final class PayordMergerLatest extends InfoMergerTemplate<PayordInfo, PayordarchInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, PayordarchInfo> getVisitorHook() {
		return new PayordVisiMergeLatest();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
