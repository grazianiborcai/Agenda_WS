package br.com.mind5.business.employeeLeaveDateSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplarchMergerToSelect extends InfoMergerTemplate<EmplarchInfo, EmplarchInfo> {

	@Override protected InfoMergerVisitor<EmplarchInfo, EmplarchInfo> getVisitorHook() {
		return new EmplarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmplarchInfo> getUniquifierHook() {
		return new EmplarchUniquifier();
	}
}
