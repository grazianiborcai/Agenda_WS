package br.com.gda.business.company.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.security.username.info.UsernameInfo;

final class CompMergerUsername extends InfoMergerTemplate<CompInfo, UsernameInfo> {
	
	@Override protected InfoMergerVisitor<CompInfo, UsernameInfo> getVisitorHook() {
		return new CompVisiMergeUsername();
	}
}
