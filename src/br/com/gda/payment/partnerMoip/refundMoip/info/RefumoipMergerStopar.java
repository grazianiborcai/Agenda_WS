package br.com.gda.payment.partnerMoip.refundMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.payment.storePartner.info.StoparInfo;

final class RefumoipMergerStopar extends InfoMergerTemplate<RefumoipInfo, StoparInfo> {

	@Override protected InfoMergerVisitor<RefumoipInfo, StoparInfo> getVisitorHook() {
		return new RefumoipVisiMergeStopar();
	}
}
