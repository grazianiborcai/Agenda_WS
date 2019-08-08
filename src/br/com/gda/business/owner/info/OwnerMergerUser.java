package br.com.gda.business.owner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.user.info.UserInfo;

final class OwnerMergerUser extends InfoMergerTemplate<OwnerInfo, UserInfo> {

	@Override protected InfoMergerVisitor<OwnerInfo, UserInfo> getVisitorHook() {
		return new OwnerVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
