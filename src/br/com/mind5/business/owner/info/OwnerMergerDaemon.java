package br.com.mind5.business.owner.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.user.info.UserInfo;

public final class OwnerMergerDaemon extends InfoMergerTemplate_<OwnerInfo, UserInfo>{

	@Override protected InfoMergerVisitor_<OwnerInfo, UserInfo> getVisitorHook() {
		return new OwnerVisiMergeDaemon();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
