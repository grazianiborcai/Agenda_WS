package br.com.mind5.business.personSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PerarchMergerToSelect extends InfoMergerTemplate_<PerarchInfo, PerarchInfo> {

	@Override protected InfoMergerVisitor_<PerarchInfo, PerarchInfo> getVisitorHook() {
		return new PerarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PerarchInfo> getUniquifierHook() {
		return new PerarchUniquifier();
	}
}
