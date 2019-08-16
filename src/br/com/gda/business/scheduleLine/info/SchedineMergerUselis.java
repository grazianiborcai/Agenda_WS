package br.com.gda.business.scheduleLine.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.userList.info.UselisInfo;

final class SchedineMergerUselis extends InfoMergerTemplate<SchedineInfo, UselisInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, UselisInfo> getVisitorHook() {
		return new SchedineVisiMergeUselis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}
}
