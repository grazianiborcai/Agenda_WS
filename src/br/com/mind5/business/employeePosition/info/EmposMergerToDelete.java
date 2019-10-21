package br.com.mind5.business.employeePosition.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmposMergerToDelete extends InfoMergerTemplate<EmposInfo, EmposInfo> {

	@Override protected InfoMergerVisitor<EmposInfo, EmposInfo> getVisitorHook() {
		return new EmposVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<EmposInfo> getUniquifierHook() {
		return new EmposUniquifier();
	}
}
