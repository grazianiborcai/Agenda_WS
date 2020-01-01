package br.com.mind5.payment.storePartnerSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoparchMergerToSelect extends InfoMergerTemplate<StoparchInfo, StoparchInfo> {

	@Override protected InfoMergerVisitor<StoparchInfo, StoparchInfo> getVisitorHook() {
		return new StoparchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoparchInfo> getUniquifierHook() {
		return new StoparchUniquifier();
	}
}
