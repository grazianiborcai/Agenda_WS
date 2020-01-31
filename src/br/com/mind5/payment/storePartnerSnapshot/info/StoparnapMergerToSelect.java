package br.com.mind5.payment.storePartnerSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoparnapMergerToSelect extends InfoMergerTemplate_<StoparnapInfo, StoparnapInfo> {

	@Override protected InfoMergerVisitor_<StoparnapInfo, StoparnapInfo> getVisitorHook() {
		return new StoparnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoparnapInfo> getUniquifierHook() {
		return new StoparnapUniquifier();
	}
}
