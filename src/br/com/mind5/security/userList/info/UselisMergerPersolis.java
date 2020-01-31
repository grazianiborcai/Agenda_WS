package br.com.mind5.security.userList.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class UselisMergerPersolis extends InfoMergerTemplate_<UselisInfo, PersolisInfo> {

	@Override protected InfoMergerVisitor_<UselisInfo, PersolisInfo> getVisitorHook() {
		return new UselisVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<UselisInfo> getUniquifierHook() {
		return new UselisUniquifier();
	}
}
