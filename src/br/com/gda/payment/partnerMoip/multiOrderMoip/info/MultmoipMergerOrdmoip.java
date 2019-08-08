package br.com.gda.payment.partnerMoip.multiOrderMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.partnerMoip.orderMoip.info.OrdmoipInfo;

final class MultmoipMergerOrdmoip extends InfoMergerTemplate<MultmoipInfo, OrdmoipInfo> {

	@Override protected InfoMergerVisitor<MultmoipInfo, OrdmoipInfo> getVisitorHook() {
		return new MultmoipVisiMergeOrdmoip();
	}
	
	
	
	@Override protected InfoUniquifier<MultmoipInfo> getUniquifierHook() {
		return new MultmoipUniquifier();
	}
}
