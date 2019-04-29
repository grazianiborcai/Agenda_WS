package br.com.gda.business.customer.info;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

public final class CusMergerUser extends InfoMergerTemplate<CusInfo, UserInfo>{

	@Override protected InfoMergerVisitorV2<CusInfo, UserInfo> getVisitorHook() {
		return new CusVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
