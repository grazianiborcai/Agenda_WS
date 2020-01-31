package br.com.mind5.payment.partnerMoip.refundMoip.info;

import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.storePartner.info.StoparInfo;

final class RefumoipMergerStopar extends InfoMergerTemplate_<RefumoipInfo, StoparInfo> {

	@Override protected InfoMergerVisitor_<RefumoipInfo, StoparInfo> getVisitorHook() {
		return new RefumoipVisiMergeStopar();
	}
}
