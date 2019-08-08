package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class MultmoipMergerPaymoip extends InfoMergerTemplate<MultmoipInfo, PaymoipInfo> {

	@Override protected InfoMergerVisitor<MultmoipInfo, PaymoipInfo> getVisitorHook() {
		return new MultmoipVisiMergePaymoip();
	}
	
	
	
	@Override protected InfoUniquifier<MultmoipInfo> getUniquifierHook() {
		return new MultmoipUniquifier();
	}
}
