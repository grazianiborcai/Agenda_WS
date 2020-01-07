package br.com.mind5.business.employeeLeaveDateRange.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplargMergerToSelect extends InfoMergerTemplate<EmplargInfo, EmplargInfo> {

	@Override protected InfoMergerVisitor<EmplargInfo, EmplargInfo> getVisitorHook() {
		return new EmplargVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<EmplargInfo> getUniquifierHook() {
		return new EmplargUniquifier();
	}
}
