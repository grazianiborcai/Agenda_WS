package br.com.mind5.security.userSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UserapMergerToSelect extends InfoMergerTemplate<UserapInfo, UserapInfo> {

	@Override protected InfoMergerVisitor<UserapInfo, UserapInfo> getVisitorHook() {
		return new UserapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
