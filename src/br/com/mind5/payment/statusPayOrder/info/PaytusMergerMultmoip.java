package br.com.mind5.payment.statusPayOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PaytusMergerMultmoip extends InfoMergerTemplate_<PaytusInfo, MultmoipInfo> {

	@Override protected InfoMergerVisitor_<PaytusInfo, MultmoipInfo> getVisitorHook() {
		return new PaytusVisiMergeMultmoip();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
