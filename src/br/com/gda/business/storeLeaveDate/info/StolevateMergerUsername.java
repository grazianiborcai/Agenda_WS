package br.com.gda.business.storeLeaveDate.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class StolevateMergerUsername extends InfoMergerTemplate<StolevateInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<StolevateInfo, UsernameInfo> getVisitorHook() {
		return new StolevateVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StolevateInfo> getUniquifierHook() {
		return new StolevateUniquifier();
	}
}
