package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StowotmMergerToUpdate extends InfoMergerTemplate_<StowotmInfo, StowotmInfo> {

	@Override protected InfoMergerVisitor_<StowotmInfo, StowotmInfo> getVisitorHook() {
		return new StowotmVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
