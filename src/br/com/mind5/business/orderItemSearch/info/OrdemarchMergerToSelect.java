package br.com.mind5.business.orderItemSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class OrdemarchMergerToSelect extends InfoMergerTemplate<OrdemarchInfo, OrdemarchInfo> {

	@Override protected InfoMergerVisitor<OrdemarchInfo, OrdemarchInfo> getVisitorHook() {
		return new OrdemarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<OrdemarchInfo> getUniquifierHook() {
		return new OrdemarchUniquifier();
	}
}
