package br.com.gda.business.companySearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CompMergerToSelect extends InfoMergerTemplate<CompInfo, CompInfo> {

	@Override protected InfoMergerVisitor<CompInfo, CompInfo> getVisitorHook() {
		return new CompVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CompInfo> getUniquifierHook() {
		return new CompUniquifier();
	}	
}
