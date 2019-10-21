package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class StowotmMergerUsername extends InfoMergerTemplate<StowotmInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<StowotmInfo, UsernameInfo> getVisitorHook() {
		return new StowotmVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
