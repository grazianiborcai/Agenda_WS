package br.com.mind5.payment.statusPayOrder.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class PaytusMergerPaymoip extends InfoMergerTemplate<PaytusInfo, PaymoipInfo> {

	@Override protected InfoMergerVisitor<PaytusInfo, PaymoipInfo> getVisitorHook() {
		return new PaytusVisiMergePaymoip();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
