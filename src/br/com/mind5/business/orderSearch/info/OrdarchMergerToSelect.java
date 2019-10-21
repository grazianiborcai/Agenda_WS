package br.com.mind5.business.orderSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdarchMergerToSelect extends InfoMergerTemplate<OrdarchInfo, OrdarchInfo> {

	@Override protected InfoMergerVisitor<OrdarchInfo, OrdarchInfo> getVisitorHook() {
		return new OrdarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdarchInfo> getUniquifierHook() {
		return new OrdarchUniquifier();
	}
}
