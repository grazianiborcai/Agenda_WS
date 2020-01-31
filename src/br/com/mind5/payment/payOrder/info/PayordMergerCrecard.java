package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class PayordMergerCrecard extends InfoMergerTemplate_<PayordInfo, CrecardInfo> {

	@Override protected InfoMergerVisitor_<PayordInfo, CrecardInfo> getVisitorHook() {
		return new PayordVisiMergeCrecard();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
