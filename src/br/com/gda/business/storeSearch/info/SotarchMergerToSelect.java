package br.com.gda.business.storeSearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SotarchMergerToSelect extends InfoMergerTemplate<SotarchInfo, SotarchInfo> {

	@Override protected InfoMergerVisitor<SotarchInfo, SotarchInfo> getVisitorHook() {
		return new SotarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<SotarchInfo> getUniquifierHook() {
		return new SotarchUniquifier();
	}
}
