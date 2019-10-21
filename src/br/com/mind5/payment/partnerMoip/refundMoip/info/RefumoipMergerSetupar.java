package br.com.mind5.payment.partnerMoip.refundMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class RefumoipMergerSetupar extends InfoMergerTemplate<RefumoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor<RefumoipInfo, SetuparInfo> getVisitorHook() {
		return new RefumoipVisiMergeSetupar();
	}
}
