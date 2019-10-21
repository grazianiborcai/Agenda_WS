package br.com.mind5.payment.statusPayOrderItem.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

final class PaytusemMergerOrdmoip extends InfoMergerTemplate<PaytusemInfo, OrdmoipInfo> {

	@Override protected InfoMergerVisitor<PaytusemInfo, OrdmoipInfo> getVisitorHook() {
		return new PaytusemVisiMergeOrdmoip();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusemInfo> getUniquifierHook() {
		return new PaytusemUniquifier();
	}
}
