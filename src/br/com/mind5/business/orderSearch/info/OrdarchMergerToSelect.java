package br.com.mind5.business.orderSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdarchMergerToSelect extends InfoMergerTemplate_<OrdarchInfo, OrdarchInfo> {

	@Override protected InfoMergerVisitor_<OrdarchInfo, OrdarchInfo> getVisitorHook() {
		return new OrdarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdarchInfo> getUniquifierHook() {
		return new OrdarchUniquifier();
	}
}
