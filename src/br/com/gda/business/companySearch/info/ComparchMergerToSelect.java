package br.com.gda.business.companySearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class ComparchMergerToSelect extends InfoMergerTemplate<ComparchInfo, ComparchInfo> {

	@Override protected InfoMergerVisitor<ComparchInfo, ComparchInfo> getVisitorHook() {
		return new ComparchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<ComparchInfo> getUniquifierHook() {
		return new ComparchUniquifier();
	}	
}
