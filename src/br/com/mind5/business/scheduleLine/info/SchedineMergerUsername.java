package br.com.mind5.business.scheduleLine.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class SchedineMergerUsername extends InfoMergerTemplate<SchedineInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<SchedineInfo, UsernameInfo> getVisitorHook() {
		return new SchedineVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<SchedineInfo> getUniquifierHook() {
		return new SchedineUniquifier();
	}	
}
