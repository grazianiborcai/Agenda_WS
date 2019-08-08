package br.com.gda.payment.statusPayOrderItem.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

final class PaytusemMergerOrdmoip extends InfoMergerTemplate<PaytusemInfo, OrdmoipInfo> {

	@Override protected InfoMergerVisitor<PaytusemInfo, OrdmoipInfo> getVisitorHook() {
		return new PaytusemVisiMergeOrdmoip();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusemInfo> getUniquifierHook() {
		return new PaytusemUniquifier();
	}
}
