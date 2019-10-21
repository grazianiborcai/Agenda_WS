package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StowotmMergerToDelete extends InfoMergerTemplate<StowotmInfo, StowotmInfo> {

	@Override protected InfoMergerVisitor<StowotmInfo, StowotmInfo> getVisitorHook() {
		return new StowotmVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
