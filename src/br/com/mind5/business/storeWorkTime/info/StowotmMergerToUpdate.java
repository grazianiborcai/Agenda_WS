package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StowotmMergerToUpdate extends InfoMergerTemplate<StowotmInfo, StowotmInfo> {

	@Override protected InfoMergerVisitor<StowotmInfo, StowotmInfo> getVisitorHook() {
		return new StowotmVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
