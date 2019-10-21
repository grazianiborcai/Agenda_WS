package br.com.mind5.payment.partnerMoip.multiPayMoip.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

final class PaymoipMergerSetupar extends InfoMergerTemplate<PaymoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitor<PaymoipInfo, SetuparInfo> getVisitorHook() {
		return new PaymoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<PaymoipInfo> getUniquifierHook() {
		return new PaymoipUniquifier();
	}
}
