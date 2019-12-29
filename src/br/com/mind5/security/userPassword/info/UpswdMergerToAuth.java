package br.com.mind5.security.userPassword.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UpswdMergerToAuth extends InfoMergerTemplate<UpswdInfo, UpswdInfo> {

	@Override protected InfoMergerVisitor<UpswdInfo, UpswdInfo> getVisitorHook() {
		return new UpswdVisiMergeToAuth();
	}
	
	
	
	@Override protected InfoUniquifier<UpswdInfo> getUniquifierHook() {
		return new UpswdUniquifier();
	}
}
