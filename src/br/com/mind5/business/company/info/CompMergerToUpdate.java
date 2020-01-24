package br.com.mind5.business.company.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CompMergerToUpdate extends InfoMergerTemplate<CompInfo, CompInfo> {

	@Override protected InfoMergerVisitor<CompInfo, CompInfo> getVisitorHook() {
		return new CompVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<CompInfo> getUniquifierHook() {
		return new CompUniquifier();
	}
}
