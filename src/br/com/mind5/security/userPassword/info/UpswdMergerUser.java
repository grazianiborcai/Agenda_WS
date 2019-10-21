package br.com.mind5.security.userPassword.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class UpswdMergerUser extends InfoMergerTemplate<UpswdInfo, UserInfo> {

	@Override protected InfoMergerVisitor<UpswdInfo, UserInfo> getVisitorHook() {
		return new UpswdVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<UpswdInfo> getUniquifierHook() {
		return new UpswdUniquifier();
	}
}
