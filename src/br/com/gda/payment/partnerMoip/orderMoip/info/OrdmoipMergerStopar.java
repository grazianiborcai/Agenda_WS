package br.com.gda.payment.partnerMoip.orderMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.storePartner.info.StoparInfo;

final class OrdmoipMergerStopar extends InfoMergerTemplate<OrdmoipInfo, StoparInfo> {

	@Override protected InfoMergerVisitorV2<OrdmoipInfo, StoparInfo> getVisitorHook() {
		return new OrdmoipVisiMergeStopar();
	}
	
	
	
	@Override protected InfoUniquifier<OrdmoipInfo> getUniquifierHook() {
		return new OrdmoipUniquifier();
	}
}
