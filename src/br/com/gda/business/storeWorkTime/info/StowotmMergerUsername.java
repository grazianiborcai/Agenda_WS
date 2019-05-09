package br.com.gda.business.storeWorkTime.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class StowotmMergerUsername extends InfoMergerTemplate<StowotmInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<StowotmInfo, UsernameInfo> getVisitorHook() {
		return new StowotmVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StowotmInfo> getUniquifierHook() {
		return new StowotmUniquifier();
	}
}
