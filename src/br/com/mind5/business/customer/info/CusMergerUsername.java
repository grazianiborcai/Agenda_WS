package br.com.mind5.business.customer.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CusMergerUsername extends InfoMergerTemplate_<CusInfo, UsernameInfo>{

	@Override protected InfoMergerVisitor_<CusInfo, UsernameInfo> getVisitorHook() {
		return new CusVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
