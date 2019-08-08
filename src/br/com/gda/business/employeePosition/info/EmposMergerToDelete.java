package br.com.gda.business.employeePosition.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmposMergerToDelete extends InfoMergerTemplate<EmposInfo, EmposInfo> {

	@Override protected InfoMergerVisitor<EmposInfo, EmposInfo> getVisitorHook() {
		return new EmposVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<EmposInfo> getUniquifierHook() {
		return new EmposUniquifier();
	}
}
