package br.com.gda.payment.payOrderItemStatus.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

final class PaytusemMergerOrdmoip extends InfoMergerTemplate<PaytusemInfo, OrdmoipInfo> {

	@Override protected InfoMergerVisitorV2<PaytusemInfo, OrdmoipInfo> getVisitorHook() {
		return new PaytusemVisiMergeOrdmoip();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusemInfo> getUniquifierHook() {
		return new PaytusemUniquifier();
	}
}
