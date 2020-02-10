package br.com.mind5.paymentPartner.partnerMoip.refundMoip.info;

import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class RefumoipMergerSetupar extends InfoMergerTemplate_<RefumoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor_<RefumoipInfo, SetuparInfo> getVisitorHook() {
		return new RefumoipVisiMergeSetupar();
	}
}
