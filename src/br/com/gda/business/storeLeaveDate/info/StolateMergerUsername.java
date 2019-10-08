package br.com.gda.business.storeLeaveDate.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class StolateMergerUsername extends InfoMergerTemplate<StolateInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<StolateInfo, UsernameInfo> getVisitorHook() {
		return new StolateVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StolateInfo> getUniquifierHook() {
		return new StolateUniquifier();
	}
}
