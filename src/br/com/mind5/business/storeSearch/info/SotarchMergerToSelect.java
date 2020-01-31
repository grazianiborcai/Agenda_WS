package br.com.mind5.business.storeSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SotarchMergerToSelect extends InfoMergerTemplate_<SotarchInfo, SotarchInfo> {

	@Override protected InfoMergerVisitor_<SotarchInfo, SotarchInfo> getVisitorHook() {
		return new SotarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SotarchInfo> getUniquifierHook() {
		return new SotarchUniquifier();
	}
}
