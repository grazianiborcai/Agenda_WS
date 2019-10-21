package br.com.mind5.payment.statusPayOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PaytusMergerMultmoip extends InfoMergerTemplate<PaytusInfo, MultmoipInfo> {

	@Override protected InfoMergerVisitor<PaytusInfo, MultmoipInfo> getVisitorHook() {
		return new PaytusVisiMergeMultmoip();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
