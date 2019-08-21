package br.com.gda.business.orderSearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrdarchMergerToSelect extends InfoMergerTemplate<OrdarchInfo, OrdarchInfo> {

	@Override protected InfoMergerVisitor<OrdarchInfo, OrdarchInfo> getVisitorHook() {
		return new OrdarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdarchInfo> getUniquifierHook() {
		return new OrdarchUniquifier();
	}
}
