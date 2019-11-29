package br.com.mind5.business.employeeMaterialSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpmarchMergerToSelect extends InfoMergerTemplate<EmpmarchInfo, EmpmarchInfo> {

	@Override protected InfoMergerVisitor<EmpmarchInfo, EmpmarchInfo> getVisitorHook() {
		return new EmpmarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmarchInfo> getUniquifierHook() {
		return new EmpmarchUniquifier();
	}
}
