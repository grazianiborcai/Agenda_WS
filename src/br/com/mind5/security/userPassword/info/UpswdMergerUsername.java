package br.com.mind5.security.userPassword.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class UpswdMergerUsername extends InfoMergerTemplate<UpswdInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<UpswdInfo, UsernameInfo> getVisitorHook() {
		return new UpswdVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<UpswdInfo> getUniquifierHook() {
		return new UpswdUniquifier();
	}
}
