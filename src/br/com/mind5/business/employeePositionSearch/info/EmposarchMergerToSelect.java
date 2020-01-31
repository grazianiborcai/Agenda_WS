package br.com.mind5.business.employeePositionSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmposarchMergerToSelect extends InfoMergerTemplate_<EmposarchInfo, EmposarchInfo> {

	@Override protected InfoMergerVisitor_<EmposarchInfo, EmposarchInfo> getVisitorHook() {
		return new EmposarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmposarchInfo> getUniquifierHook() {
		return new EmposarchUniquifier();
	}
}
