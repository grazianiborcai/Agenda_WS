package br.com.mind5.payment.storePartnerSnapshot.info;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoparnapMergerPaypar extends InfoMergerTemplate_<StoparnapInfo, PayparInfo> {

	@Override protected InfoMergerVisitor_<StoparnapInfo, PayparInfo> getVisitorHook() {
		return new StoparnapVisiMergePaypar();
	}
	
	
	
	@Override protected InfoUniquifier<StoparnapInfo> getUniquifierHook() {
		return new StoparnapUniquifier();
	}
}
