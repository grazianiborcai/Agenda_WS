package br.com.mind5.business.storeLeaveDateRange.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StolargMergerToSelect extends InfoMergerTemplate<StolargInfo, StolargInfo> {

	@Override protected InfoMergerVisitor<StolargInfo, StolargInfo> getVisitorHook() {
		return new StolargVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StolargInfo> getUniquifierHook() {
		return new StolargUniquifier();
	}
}
