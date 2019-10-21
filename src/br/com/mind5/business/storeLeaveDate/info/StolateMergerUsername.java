package br.com.mind5.business.storeLeaveDate.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class StolateMergerUsername extends InfoMergerTemplate<StolateInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<StolateInfo, UsernameInfo> getVisitorHook() {
		return new StolateVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<StolateInfo> getUniquifierHook() {
		return new StolateUniquifier();
	}
}
