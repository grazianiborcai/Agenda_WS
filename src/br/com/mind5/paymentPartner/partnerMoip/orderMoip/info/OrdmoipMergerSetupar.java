package br.com.mind5.paymentPartner.partnerMoip.orderMoip.info;

import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class OrdmoipMergerSetupar extends InfoMergerTemplate_<OrdmoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor_<OrdmoipInfo, SetuparInfo> getVisitorHook() {
		return new OrdmoipVisiMergeSetupar();
	}
}
