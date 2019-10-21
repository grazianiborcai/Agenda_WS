package br.com.mind5.payment.storePartnerSnapshot.info;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoparnapMergerPaypar extends InfoMergerTemplate<StoparnapInfo, PayparInfo> {

	@Override protected InfoMergerVisitor<StoparnapInfo, PayparInfo> getVisitorHook() {
		return new StoparnapVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<StoparnapInfo> getUniquifierHook() {
		return new StoparnapUniquifier();
	}
}
