package br.com.gda.security.userList.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class UselisMergerToSelect extends InfoMergerTemplate<UselisInfo, UselisInfo> {

	@Override protected InfoMergerVisitor<UselisInfo, UselisInfo> getVisitorHook() {
		return new UselisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<UselisInfo> getUniquifierHook() {
		return new UselisUniquifier();
	}
}
