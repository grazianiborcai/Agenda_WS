package br.com.mind5.payment.partnerMoip.refundMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class RefumoipMergerStopar extends InfoMergerTemplate<RefumoipInfo, StoparInfo> {

	@Override protected InfoMergerVisitor<RefumoipInfo, StoparInfo> getVisitorHook() {
		return new RefumoipVisiMergeStopar();
	}
}
