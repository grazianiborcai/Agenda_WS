package br.com.mind5.business.owner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

public final class OwnerMergerDaemon extends InfoMergerTemplate<OwnerInfo, UserInfo>{

	@Override protected InfoMergerVisitor<OwnerInfo, UserInfo> getVisitorHook() {
		return new OwnerVisiMergeDaemon();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
