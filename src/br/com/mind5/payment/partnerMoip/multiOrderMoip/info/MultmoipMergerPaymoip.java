package br.com.mind5.payment.partnerMoip.multiOrderMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class MultmoipMergerPaymoip extends InfoMergerTemplate<MultmoipInfo, PaymoipInfo> {

	@Override protected InfoMergerVisitor<MultmoipInfo, PaymoipInfo> getVisitorHook() {
		return new MultmoipVisiMergePaymoip();
	}
	
	
	
	@Override protected InfoUniquifier<MultmoipInfo> getUniquifierHook() {
		return new MultmoipUniquifier();
	}
}
