package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class SchedineMergerUsername extends InfoMergerTemplate_<SchedineInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<SchedineInfo, UsernameInfo> getVisitorHook() {
		return new SchedineVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}	
}
