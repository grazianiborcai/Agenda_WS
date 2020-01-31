package br.com.mind5.security.userSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserarchMergerToSelect extends InfoMergerTemplate_<UserarchInfo, UserarchInfo> {

	@Override protected InfoMergerVisitor_<UserarchInfo, UserarchInfo> getVisitorHook() {
		return new UserarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<UserarchInfo> getUniquifierHook() {
		return new UserarchUniquifier();
	}
}
