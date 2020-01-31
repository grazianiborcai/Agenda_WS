package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class StolateMergerUsername extends InfoMergerTemplate_<StolateInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<StolateInfo, UsernameInfo> getVisitorHook() {
		return new StolateVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StolateInfo> getUniquifierHook() {
		return new StolateUniquifier();
	}
}
