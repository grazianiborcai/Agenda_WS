package br.com.mind5.payment.storePartnerSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoparchMergerToSelect extends InfoMergerTemplate_<StoparchInfo, StoparchInfo> {

	@Override protected InfoMergerVisitor_<StoparchInfo, StoparchInfo> getVisitorHook() {
		return new StoparchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StoparchInfo> getUniquifierHook() {
		return new StoparchUniquifier();
	}
}
