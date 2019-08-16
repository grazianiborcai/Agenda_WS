package br.com.gda.business.scheduleLine.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class SchedineMergerUsername extends InfoMergerTemplate<SchedineInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, UsernameInfo> getVisitorHook() {
		return new SchedineVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}	
}
