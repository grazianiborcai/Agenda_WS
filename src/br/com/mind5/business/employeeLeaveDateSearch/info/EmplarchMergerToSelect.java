package br.com.mind5.business.employeeLeaveDateSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplarchMergerToSelect extends InfoMergerTemplate_<EmplarchInfo, EmplarchInfo> {

	@Override protected InfoMergerVisitor_<EmplarchInfo, EmplarchInfo> getVisitorHook() {
		return new EmplarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmplarchInfo> getUniquifierHook() {
		return new EmplarchUniquifier();
	}
}
