package br.com.gda.payment.statusPayOrder.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.partnerMoip.multiPayMoip.info.PaymoipInfo;

final class PaytusMergerPaymoip extends InfoMergerTemplate<PaytusInfo, PaymoipInfo> {

	@Override protected InfoMergerVisitor<PaytusInfo, PaymoipInfo> getVisitorHook() {
		return new PaytusVisiMergePaymoip();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
