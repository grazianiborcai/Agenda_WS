package br.com.mind5.business.employeeMaterialSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpmarchMergerToSelect extends InfoMergerTemplate_<EmpmarchInfo, EmpmarchInfo> {

	@Override protected InfoMergerVisitor_<EmpmarchInfo, EmpmarchInfo> getVisitorHook() {
		return new EmpmarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmpmarchInfo> getUniquifierHook() {
		return new EmpmarchUniquifier();
	}
}
