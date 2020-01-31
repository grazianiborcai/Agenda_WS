package br.com.mind5.business.employeePosition.info;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmposMergerEmposarch extends InfoMergerTemplate_<EmposInfo, EmposarchInfo> {

	@Override protected InfoMergerVisitor_<EmposInfo, EmposarchInfo> getVisitorHook() {
		return new EmposVisiMergeEmposarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmposInfo> getUniquifierHook() {
		return new EmposUniquifier();
	}
}
