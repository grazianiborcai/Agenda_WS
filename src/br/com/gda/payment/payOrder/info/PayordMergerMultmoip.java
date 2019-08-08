package br.com.gda.payment.payOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PayordMergerMultmoip extends InfoMergerTemplate<PayordInfo, MultmoipInfo> {

	@Override protected InfoMergerVisitor<PayordInfo, MultmoipInfo> getVisitorHook() {
		return new PayordVisiMergeMultmoip();
	}
	
	
	
	@Override protected InfoUniquifier<PayordInfo> getUniquifierHook() {
		return new PayordUniquifier();
	}
}
