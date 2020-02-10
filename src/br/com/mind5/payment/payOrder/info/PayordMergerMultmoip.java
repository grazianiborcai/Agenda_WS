package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.paymentPartner.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PayordMergerMultmoip extends InfoMergerTemplate_<PayordInfo, MultmoipInfo> {

	@Override protected InfoMergerVisitor_<PayordInfo, MultmoipInfo> getVisitorHook() {
		return new PayordVisiMergeMultmoip();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
