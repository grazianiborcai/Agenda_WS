package br.com.gda.payment.partnerMoip.refundMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.storePartner.info.StoparInfo;

final class RefumoipMergerStopar extends InfoMergerTemplate<RefumoipInfo, StoparInfo> {

	@Override protected InfoMergerVisitorV2<RefumoipInfo, StoparInfo> getVisitorHook() {
		return new RefumoipVisiMergeStopar();
	}
}
