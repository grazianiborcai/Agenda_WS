package br.com.gda.payment.partnerMoip.orderMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class OrdmoipMergerSetupar extends InfoMergerTemplate<OrdmoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitorV2<OrdmoipInfo, SetuparInfo> getVisitorHook() {
		return new OrdmoipVisiMergeSetupar();
	}
}
