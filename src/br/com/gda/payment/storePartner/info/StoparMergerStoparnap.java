package br.com.gda.payment.storePartner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;

final class StoparMergerStoparnap extends InfoMergerTemplate<StoparInfo, StoparnapInfo> {

	@Override protected InfoMergerVisitor<StoparInfo, StoparnapInfo> getVisitorHook() {
		return new StoparVisiMergeStoparnap();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
