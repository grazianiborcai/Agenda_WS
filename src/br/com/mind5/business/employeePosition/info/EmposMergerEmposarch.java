package br.com.mind5.business.employeePosition.info;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmposMergerEmposarch extends InfoMergerTemplate<EmposInfo, EmposarchInfo> {

	@Override protected InfoMergerVisitor<EmposInfo, EmposarchInfo> getVisitorHook() {
		return new EmposVisiMergeEmposarch();
	}
	
	
	
	@Override protected InfoUniquifier<EmposInfo> getUniquifierHook() {
		return new EmposUniquifier();
	}
}
