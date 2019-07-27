package br.com.gda.payment.payOrderStatus.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.partnerMoip.multiOrderMoip.info.MultmoipInfo;

final class PaytusMergerMultmoip extends InfoMergerTemplate<PaytusInfo, MultmoipInfo> {

	@Override protected InfoMergerVisitorV2<PaytusInfo, MultmoipInfo> getVisitorHook() {
		return new PaytusVisiMergeMultmoip();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusInfo> getUniquifierHook() {
		return new PaytusUniquifier();
	}
}
