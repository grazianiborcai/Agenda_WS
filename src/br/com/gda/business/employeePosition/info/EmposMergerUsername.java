package br.com.gda.business.employeePosition.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;
import br.com.gda.security.username.info.UsernameInfo;

final class EmposMergerUsername extends InfoMergerTemplate<EmposInfo, UsernameInfo> {

	@Override protected InfoMergerVisitorV2<EmposInfo, UsernameInfo> getVisitorHook() {
		return new EmposVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<EmposInfo> getUniquifierHook() {
		return new EmposUniquifier();
	}
}
