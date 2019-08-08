package br.com.gda.payment.payOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.creditCard.info.CrecardInfo;

final class PayordMergerCrecard extends InfoMergerTemplate<PayordInfo, CrecardInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, CrecardInfo> getVisitorHook() {
		return new PayordVisiMergeCrecard();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
