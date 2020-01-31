package br.com.mind5.security.userPassword.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class UpswdMergerUsername extends InfoMergerTemplate_<UpswdInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<UpswdInfo, UsernameInfo> getVisitorHook() {
		return new UpswdVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<UpswdInfo> getUniquifierHook() {
		return new UpswdUniquifier();
	}
}
