package br.com.mind5.payment.partnerMoip.orderMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class OrdmoipMergerSetupar extends InfoMergerTemplate<OrdmoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor<OrdmoipInfo, SetuparInfo> getVisitorHook() {
		return new OrdmoipVisiMergeSetupar();
	}
}
