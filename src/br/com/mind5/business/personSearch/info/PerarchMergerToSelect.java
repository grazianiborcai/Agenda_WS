package br.com.mind5.business.personSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PerarchMergerToSelect extends InfoMergerTemplate<PerarchInfo, PerarchInfo> {

	@Override protected InfoMergerVisitor<PerarchInfo, PerarchInfo> getVisitorHook() {
		return new PerarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PerarchInfo> getUniquifierHook() {
		return new PerarchUniquifier();
	}
}
