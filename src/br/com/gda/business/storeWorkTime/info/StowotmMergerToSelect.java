package br.com.gda.business.storeWorkTime.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StowotmMergerToSelect extends InfoMergerTemplate<StowotmInfo, StowotmInfo> {

	@Override protected InfoMergerVisitor<StowotmInfo, StowotmInfo> getVisitorHook() {
		return new StowotmVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
