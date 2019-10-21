package br.com.mind5.business.companySearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class ComparchMergerToSelect extends InfoMergerTemplate<ComparchInfo, ComparchInfo> {

	@Override protected InfoMergerVisitor<ComparchInfo, ComparchInfo> getVisitorHook() {
		return new ComparchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<ComparchInfo> getUniquifierHook() {
		return new ComparchUniquifier();
	}	
}
