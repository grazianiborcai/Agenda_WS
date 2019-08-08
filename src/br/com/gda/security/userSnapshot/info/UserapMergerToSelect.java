package br.com.gda.security.userSnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class UserapMergerToSelect extends InfoMergerTemplate<UserapInfo, UserapInfo> {

	@Override protected InfoMergerVisitor<UserapInfo, UserapInfo> getVisitorHook() {
		return new UserapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
