package br.com.mind5.security.userPassword.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.user.info.UserInfo;

final class UpswdMergerUser extends InfoMergerTemplate_<UpswdInfo, UserInfo> {

	@Override protected InfoMergerVisitor_<UpswdInfo, UserInfo> getVisitorHook() {
		return new UpswdVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<UpswdInfo> getUniquifierHook() {
		return new UpswdUniquifier();
	}
}
