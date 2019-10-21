package br.com.mind5.payment.partnerMoip.multiOrderMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

final class MultmoipMergerOrdmoip extends InfoMergerTemplate<MultmoipInfo, OrdmoipInfo> {

	@Override protected InfoMergerVisitor<MultmoipInfo, OrdmoipInfo> getVisitorHook() {
		return new MultmoipVisiMergeOrdmoip();
	}
	
	
	
	@Override protected InfoUniquifier<MultmoipInfo> getUniquifierHook() {
		return new MultmoipUniquifier();
	}
}
