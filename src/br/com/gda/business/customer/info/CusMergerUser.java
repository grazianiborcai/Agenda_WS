package br.com.gda.business.customer.info;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class CusMergerUser extends InfoMergerTemplate<CusInfo, UserInfo>{

	@Override protected InfoMergerVisitor<CusInfo, UserInfo, CusInfo> getVisitorHook() {
		return new CusVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
