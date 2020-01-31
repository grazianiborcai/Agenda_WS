package br.com.mind5.security.userList.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UselisMergerToSelect extends InfoMergerTemplate_<UselisInfo, UselisInfo> {

	@Override protected InfoMergerVisitor_<UselisInfo, UselisInfo> getVisitorHook() {
		return new UselisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<UselisInfo> getUniquifierHook() {
		return new UselisUniquifier();
	}
}
