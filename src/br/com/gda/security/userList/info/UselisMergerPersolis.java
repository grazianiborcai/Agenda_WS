package br.com.gda.security.userList.info;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class UselisMergerPersolis extends InfoMergerTemplate<UselisInfo, PersolisInfo> {

	@Override protected InfoMergerVisitor<UselisInfo, PersolisInfo> getVisitorHook() {
		return new UselisVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<UselisInfo> getUniquifierHook() {
		return new UselisUniquifier();
	}
}
