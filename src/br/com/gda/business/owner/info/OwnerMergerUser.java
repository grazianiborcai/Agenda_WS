package br.com.gda.business.owner.info;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class OwnerMergerUser extends InfoMergerTemplate<OwnerInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<OwnerInfo, UserInfo> getVisitorHook() {
		return new OwnerVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<OwnerInfo> getUniquifierHook() {
		return new OwnerUniquifier();
	}
}
