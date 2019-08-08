package br.com.gda.payment.storePartnerSnapshot.info;

import br.com.gda.business.masterData.info.PayparInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoparnapMergerPaypar extends InfoMergerTemplate<StoparnapInfo, PayparInfo> {

	@Override protected InfoMergerVisitor<StoparnapInfo, PayparInfo> getVisitorHook() {
		return new StoparnapVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<StoparnapInfo> getUniquifierHook() {
		return new StoparnapUniquifier();
	}
}
