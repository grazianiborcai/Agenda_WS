package br.com.mind5.payment.payOrder.info;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PayordMergerPaypar extends InfoMergerTemplate<PayordInfo, PayparInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, PayparInfo> getVisitorHook() {
		return new PayordVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
