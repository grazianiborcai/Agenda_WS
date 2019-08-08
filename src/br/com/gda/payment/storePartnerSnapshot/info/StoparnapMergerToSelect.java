package br.com.gda.payment.storePartnerSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoparnapMergerToSelect extends InfoMergerTemplate<StoparnapInfo, StoparnapInfo> {

	@Override protected InfoMergerVisitor<StoparnapInfo, StoparnapInfo> getVisitorHook() {
		return new StoparnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoparnapInfo> getUniquifierHook() {
		return new StoparnapUniquifier();
	}
}
