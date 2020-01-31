package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class StowotmMergerUsername extends InfoMergerTemplate_<StowotmInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<StowotmInfo, UsernameInfo> getVisitorHook() {
		return new StowotmVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
