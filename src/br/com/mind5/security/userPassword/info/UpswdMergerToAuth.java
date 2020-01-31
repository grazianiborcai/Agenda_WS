package br.com.mind5.security.userPassword.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UpswdMergerToAuth extends InfoMergerTemplate_<UpswdInfo, UpswdInfo> {

	@Override protected InfoMergerVisitor_<UpswdInfo, UpswdInfo> getVisitorHook() {
		return new UpswdVisiMergeToAuth();
	}
	
	
	
	@Override protected InfoUniquifier<UpswdInfo> getUniquifierHook() {
		return new UpswdUniquifier();
	}
}
