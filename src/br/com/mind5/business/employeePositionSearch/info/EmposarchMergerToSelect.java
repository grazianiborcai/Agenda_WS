package br.com.mind5.business.employeePositionSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmposarchMergerToSelect extends InfoMergerTemplate<EmposarchInfo, EmposarchInfo> {

	@Override protected InfoMergerVisitor<EmposarchInfo, EmposarchInfo> getVisitorHook() {
		return new EmposarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmposarchInfo> getUniquifierHook() {
		return new EmposarchUniquifier();
	}
}
