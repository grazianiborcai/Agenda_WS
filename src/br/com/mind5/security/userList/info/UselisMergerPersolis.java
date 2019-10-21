package br.com.mind5.security.userList.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class UselisMergerPersolis extends InfoMergerTemplate<UselisInfo, PersolisInfo> {

	@Override protected InfoMergerVisitor<UselisInfo, PersolisInfo> getVisitorHook() {
		return new UselisVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<UselisInfo> getUniquifierHook() {
		return new UselisUniquifier();
	}
}
