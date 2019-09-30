package br.com.gda.business.personSearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PerarchMergerToSelect extends InfoMergerTemplate<PerarchInfo, PerarchInfo> {

	@Override protected InfoMergerVisitor<PerarchInfo, PerarchInfo> getVisitorHook() {
		return new PerarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PerarchInfo> getUniquifierHook() {
		return new PerarchUniquifier();
	}
}
