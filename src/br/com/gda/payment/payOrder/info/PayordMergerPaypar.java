package br.com.gda.payment.payOrder.info;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PayordMergerPaypar extends InfoMergerTemplate<PayordInfo, PayparInfo> {

	@Override protected InfoMergerVisitorV2<PayordInfo, PayparInfo> getVisitorHook() {
		return new PayordVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
