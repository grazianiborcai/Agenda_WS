package br.com.mind5.business.customer.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

public final class CusMergerDaemon extends InfoMergerTemplate<CusInfo, UserInfo>{

	@Override protected InfoMergerVisitor<CusInfo, UserInfo> getVisitorHook() {
		return new CusVisiMergeDaemon();
	}
	
	
	
	@Override protected InfoUniquifier<CusInfo> getUniquifierHook() {
		return new CusUniquifier();
	}
}
