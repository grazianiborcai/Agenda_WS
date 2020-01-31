package br.com.mind5.payment.payOrder.info;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PayordMergerPaypar extends InfoMergerTemplate_<PayordInfo, PayparInfo> {

	@Override protected InfoMergerVisitor_<PayordInfo, PayparInfo> getVisitorHook() {
		return new PayordVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
