package br.com.mind5.business.employeePosition.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class EmposMergerUsername extends InfoMergerTemplate<EmposInfo, UsernameInfo> {

	@Override protected InfoMergerVisitor<EmposInfo, UsernameInfo> getVisitorHook() {
		return new EmposVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmposInfo> getUniquifierHook() {
		return new EmposUniquifier();
	}
}
