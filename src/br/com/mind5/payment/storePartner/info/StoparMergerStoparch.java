package br.com.mind5.payment.storePartner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

final class StoparMergerStoparch extends InfoMergerTemplate<StoparInfo, StoparchInfo> {

	@Override protected InfoMergerVisitor<StoparInfo, StoparchInfo> getVisitorHook() {
		return new StoparVisiMergeStoparch();
	}
	
	
	
	@Override protected InfoUniquifier<StoparInfo> getUniquifierHook() {
		return new StoparUniquifier();
	}
}
