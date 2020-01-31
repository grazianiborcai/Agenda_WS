package br.com.mind5.business.employeePosition.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmposMergerToSelect extends InfoMergerTemplate_<EmposInfo, EmposInfo> {

	@Override protected InfoMergerVisitor_<EmposInfo, EmposInfo> getVisitorHook() {
		return new EmposVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmposInfo> getUniquifierHook() {
		return new EmposUniquifier();
	}
}
