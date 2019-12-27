package br.com.mind5.security.userSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserarchMergerToSelect extends InfoMergerTemplate<UserarchInfo, UserarchInfo> {

	@Override protected InfoMergerVisitor<UserarchInfo, UserarchInfo> getVisitorHook() {
		return new UserarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<UserarchInfo> getUniquifierHook() {
		return new UserarchUniquifier();
	}
}
