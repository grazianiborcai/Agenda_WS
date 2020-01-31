package br.com.mind5.business.customer.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.user.info.UserInfo;

public final class CusMergerUser extends InfoMergerTemplate_<CusInfo, UserInfo>{

	@Override protected InfoMergerVisitor_<CusInfo, UserInfo> getVisitorHook() {
		return new CusVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
