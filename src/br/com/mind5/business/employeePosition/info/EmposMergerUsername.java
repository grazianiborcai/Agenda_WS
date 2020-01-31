package br.com.mind5.business.employeePosition.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmposMergerUsername extends InfoMergerTemplate_<EmposInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor_<EmposInfo, UsernameInfo> getVisitorHook() {
		return new EmposVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmposInfo> getUniquifierHook() {
		return new EmposUniquifier();
	}
}
