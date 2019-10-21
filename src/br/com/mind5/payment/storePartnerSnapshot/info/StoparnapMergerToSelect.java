package br.com.mind5.payment.storePartnerSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoparnapMergerToSelect extends InfoMergerTemplate<StoparnapInfo, StoparnapInfo> {

	@Override protected InfoMergerVisitor<StoparnapInfo, StoparnapInfo> getVisitorHook() {
		return new StoparnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoparnapInfo> getUniquifierHook() {
		return new StoparnapUniquifier();
	}
}
