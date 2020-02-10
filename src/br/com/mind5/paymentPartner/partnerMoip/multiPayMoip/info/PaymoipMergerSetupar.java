package br.com.mind5.paymentPartner.partnerMoip.multiPayMoip.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class PaymoipMergerSetupar extends InfoMergerTemplate_<PaymoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor_<PaymoipInfo, SetuparInfo> getVisitorHook() {
		return new PaymoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<PaymoipInfo> getUniquifierHook() {
		return new PaymoipUniquifier();
	}
}
