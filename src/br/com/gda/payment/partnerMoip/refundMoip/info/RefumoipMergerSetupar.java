package br.com.gda.payment.partnerMoip.refundMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class RefumoipMergerSetupar extends InfoMergerTemplate<RefumoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitorV2<RefumoipInfo, SetuparInfo> getVisitorHook() {
		return new RefumoipVisiMergeSetupar();
	}
}
