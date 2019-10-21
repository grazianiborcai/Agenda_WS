package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

final class StoparMergerStoparnap extends InfoMergerTemplate<StoparInfo, StoparnapInfo> {

	@Override protected InfoMergerVisitor<StoparInfo, StoparnapInfo> getVisitorHook() {
		return new StoparVisiMergeStoparnap();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
