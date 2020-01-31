package br.com.mind5.payment.statusPayOrderItem.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

final class PaytusemMergerOrdmoip extends InfoMergerTemplate_<PaytusemInfo, OrdmoipInfo> {

	@Override protected InfoMergerVisitor_<PaytusemInfo, OrdmoipInfo> getVisitorHook() {
		return new PaytusemVisiMergeOrdmoip();
	}
	
	
	
	@Override protected InfoUniquifier<PaytusemInfo> getUniquifierHook() {
		return new PaytusemUniquifier();
	}
}
