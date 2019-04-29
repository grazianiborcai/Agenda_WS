package br.com.gda.business.employeePosition.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmposMergerToDelete extends InfoMergerTemplate<EmposInfo, EmposInfo> {

	@Override protected InfoMergerVisitorV2<EmposInfo, EmposInfo> getVisitorHook() {
		return new EmposVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<EmposInfo> getUniquifierHook() {
		return new EmposUniquifier();
	}
}
