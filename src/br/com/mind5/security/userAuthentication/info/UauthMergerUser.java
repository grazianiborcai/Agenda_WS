package br.com.mind5.security.userAuthentication.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.user.info.UserInfo;

final class UauthMergerUser extends InfoMergerTemplate<UauthInfo, UserInfo> {

	@Override protected InfoMergerVisitor<UauthInfo, UserInfo> getVisitorHook() {
		return new UauthVisiMergeUser();
	}
	
	
	
	@Override protected InfoUniquifier<UauthInfo> getUniquifierHook() {
		return new UauthUniquifier();
	}
}
