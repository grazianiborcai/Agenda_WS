package br.com.mind5.security.userSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UserapMergerToSelect extends InfoMergerTemplate_<UserapInfo, UserapInfo> {

	@Override protected InfoMergerVisitor_<UserapInfo, UserapInfo> getVisitorHook() {
		return new UserapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<UserapInfo> getUniquifierHook() {
		return new UserapUniquifier();
	}
}
