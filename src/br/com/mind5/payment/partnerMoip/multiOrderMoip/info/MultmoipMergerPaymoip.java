package br.com.mind5.payment.partnerMoip.multiOrderMoip.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class MultmoipMergerPaymoip extends InfoMergerTemplate_<MultmoipInfo, PaymoipInfo> {

	@Override protected InfoMergerVisitor_<MultmoipInfo, PaymoipInfo> getVisitorHook() {
		return new MultmoipVisiMergePaymoip();
	}
	
	
	
	@Override protected InfoUniquifier<MultmoipInfo> getUniquifierHook() {
		return new MultmoipUniquifier();
	}
}
