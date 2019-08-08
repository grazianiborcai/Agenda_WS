package br.com.gda.business.customer.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.user.info.UserInfo;

public final class CusMergerUser extends InfoMergerTemplate<CusInfo, UserInfo>{

	@Override protected InfoMergerVisitor<CusInfo, UserInfo> getVisitorHook() {
		return new CusVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
