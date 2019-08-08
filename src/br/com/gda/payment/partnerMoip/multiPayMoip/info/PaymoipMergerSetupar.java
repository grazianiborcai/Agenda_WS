package br.com.gda.payment.partnerMoip.multiPayMoip.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.setupPartner.info.SetuparInfo;

final class PaymoipMergerSetupar extends InfoMergerTemplate<PaymoipInfo, SetuparInfo> {

	@Override protected InfoMergerVisitorV2<PaymoipInfo, SetuparInfo> getVisitorHook() {
		return new PaymoipVisiMergeSetupar();
	}
	
	
	
	@Override protected InfoUniquifier<PaymoipInfo> getUniquifierHook() {
		return new PaymoipUniquifier();
	}
}
