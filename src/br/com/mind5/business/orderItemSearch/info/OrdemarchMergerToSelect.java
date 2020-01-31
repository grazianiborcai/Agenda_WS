package br.com.mind5.business.orderItemSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class OrdemarchMergerToSelect extends InfoMergerTemplate_<OrdemarchInfo, OrdemarchInfo> {

	@Override protected InfoMergerVisitor_<OrdemarchInfo, OrdemarchInfo> getVisitorHook() {
		return new OrdemarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemarchInfo> getUniquifierHook() {
		return new OrdemarchUniquifier();
	}
}
