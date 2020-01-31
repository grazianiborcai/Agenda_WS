package br.com.mind5.payment.partnerMoip.multiOrderMoip.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

final class MultmoipMergerOrdmoip extends InfoMergerTemplate_<MultmoipInfo, OrdmoipInfo> {

	@Override protected InfoMergerVisitor_<MultmoipInfo, OrdmoipInfo> getVisitorHook() {
		return new MultmoipVisiMergeOrdmoip();
	}
	
	
	
	@Override protected InfoUniquifier<MultmoipInfo> getUniquifierHook() {
		return new MultmoipUniquifier();
	}
}
