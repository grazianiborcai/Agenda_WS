package br.com.mind5.security.username.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UsernameMergerToSelect extends InfoMergerTemplate<UsernameInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<UsernameInfo, UsernameInfo> getVisitorHook() {
		return new UsernameVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<UsernameInfo> getUniquifierHook() {
		return new UsernameUniquifier();
	}
}
