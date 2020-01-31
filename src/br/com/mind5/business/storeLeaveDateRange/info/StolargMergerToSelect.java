package br.com.mind5.business.storeLeaveDateRange.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StolargMergerToSelect extends InfoMergerTemplate_<StolargInfo, StolargInfo> {

	@Override protected InfoMergerVisitor_<StolargInfo, StolargInfo> getVisitorHook() {
		return new StolargVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StolargInfo> getUniquifierHook() {
		return new StolargUniquifier();
	}
}
