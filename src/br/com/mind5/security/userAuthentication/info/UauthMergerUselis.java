package br.com.mind5.security.userAuthentication.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.userList.info.UselisInfo;

final class UauthMergerUselis extends InfoMergerTemplate<UauthInfo, UselisInfo> {

	@Override protected InfoMergerVisitor<UauthInfo, UselisInfo> getVisitorHook() {
		return new UauthVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<UauthInfo> getUniquifierHook() {
		return new UauthUniquifier();
	}
}
