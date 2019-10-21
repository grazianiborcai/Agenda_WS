package br.com.mind5.business.company.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.security.username.info.UsernameInfo;

final class CompMergerUsername extends InfoMergerTemplate<CompInfo, UsernameInfo> {
	
	@Override protected InfoMergerVisitor<CompInfo, UsernameInfo> getVisitorHook() {
		return new CompVisiMergeUsername();
	}
	
	
	
	@Override protected InfoUniquifier<CompInfo> getUniquifierHook() {
		return new CompUniquifier();
	}	
}
