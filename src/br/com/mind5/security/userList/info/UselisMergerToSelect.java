package br.com.mind5.security.userList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UselisMergerToSelect extends InfoMergerTemplate<UselisInfo, UselisInfo> {

	@Override protected InfoMergerVisitor<UselisInfo, UselisInfo> getVisitorHook() {
		return new UselisVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<UselisInfo> getUniquifierHook() {
		return new UselisUniquifier();
	}
}
