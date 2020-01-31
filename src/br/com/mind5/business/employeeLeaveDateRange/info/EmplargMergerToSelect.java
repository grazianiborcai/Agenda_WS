package br.com.mind5.business.employeeLeaveDateRange.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplargMergerToSelect extends InfoMergerTemplate_<EmplargInfo, EmplargInfo> {

	@Override protected InfoMergerVisitor_<EmplargInfo, EmplargInfo> getVisitorHook() {
		return new EmplargVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmplargInfo> getUniquifierHook() {
		return new EmplargUniquifier();
	}
}
