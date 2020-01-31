package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

final class StoparMergerStoparnap extends InfoMergerTemplate_<StoparInfo, StoparnapInfo> {

	@Override protected InfoMergerVisitor_<StoparInfo, StoparnapInfo> getVisitorHook() {
		return new StoparVisiMergeStoparnap();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
