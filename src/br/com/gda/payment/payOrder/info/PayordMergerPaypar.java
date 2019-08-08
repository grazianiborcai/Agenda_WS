package br.com.gda.payment.payOrder.info;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PayordMergerPaypar extends InfoMergerTemplate<PayordInfo, PayparInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, PayparInfo> getVisitorHook() {
		return new PayordVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
