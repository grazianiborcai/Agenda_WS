package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

final class PayordMergerLatest extends InfoMergerTemplate_<PayordInfo, PayordarchInfo> {

	@Override protected InfoMergerVisitor_<PayordInfo, PayordarchInfo> getVisitorHook() {
		return new PayordVisiMergeLatest();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
