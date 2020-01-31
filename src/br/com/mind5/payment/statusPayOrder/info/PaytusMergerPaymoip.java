package br.com.mind5.payment.statusPayOrder.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class PaytusMergerPaymoip extends InfoMergerTemplate_<PaytusInfo, PaymoipInfo> {

	@Override protected InfoMergerVisitor_<PaytusInfo, PaymoipInfo> getVisitorHook() {
		return new PaytusVisiMergePaymoip();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
