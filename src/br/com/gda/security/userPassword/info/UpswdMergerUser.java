package br.com.gda.security.userPassword.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.user.info.UserInfo;

final class UpswdMergerUser extends InfoMergerTemplate<UpswdInfo, UserInfo> {

	@Override protected InfoMergerVisitorV2<UpswdInfo, UserInfo> getVisitorHook() {
		return new UpswdVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<UpswdInfo> getUniquifierHook() {
		return new UpswdUniquifier();
	}
}
