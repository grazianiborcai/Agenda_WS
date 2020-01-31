package br.com.mind5.security.username.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UsernameMergerToSelect extends InfoMergerTemplate_<UsernameInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<UsernameInfo, UsernameInfo> getVisitorHook() {
		return new UsernameVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<UsernameInfo> getUniquifierHook() {
		return new UsernameUniquifier();
	}
}
