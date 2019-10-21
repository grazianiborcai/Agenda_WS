package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

final class PayordMergerCrecard extends InfoMergerTemplate<PayordInfo, CrecardInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, CrecardInfo> getVisitorHook() {
		return new PayordVisiMergeCrecard();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
