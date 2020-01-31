package br.com.mind5.business.companySearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class ComparchMergerToSelect extends InfoMergerTemplate_<ComparchInfo, ComparchInfo> {

	@Override protected InfoMergerVisitor_<ComparchInfo, ComparchInfo> getVisitorHook() {
		return new ComparchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<ComparchInfo> getUniquifierHook() {
		return new ComparchUniquifier();
	}	
}
