package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

final class StoparMergerStoparch extends InfoMergerTemplate_<StoparInfo, StoparchInfo> {

	@Override protected InfoMergerVisitor_<StoparInfo, StoparchInfo> getVisitorHook() {
		return new StoparVisiMergeStoparch();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
