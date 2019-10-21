package br.com.mind5.payment.payOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PayordMergerMultmoip extends InfoMergerTemplate<PayordInfo, MultmoipInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, MultmoipInfo> getVisitorHook() {
		return new PayordVisiMergeMultmoip();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
