package br.com.mind5.business.company.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;
import br.com.mind5.security.username.info.UsernameInfo;

final class CompMergerUsername extends InfoMergerTemplate_<CompInfo, UsernameInfo> {
	
	@Override protected InfoMergerVisitor_<CompInfo, UsernameInfo> getVisitorHook() {
		return new CompVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CompInfo> getUniquifierHook() {
		return new CompUniquifier();
	}	
}
