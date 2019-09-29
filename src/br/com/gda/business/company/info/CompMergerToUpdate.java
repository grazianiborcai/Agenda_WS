package br.com.gda.business.company.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CompMergerToUpdate extends InfoMergerTemplate<CompInfo, CompInfo> {

	@Override protected InfoMergerVisitor<CompInfo, CompInfo> getVisitorHook() {
		return new OwnerVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<CompInfo> getUniquifierHook() {
		return new CompUniquifier();
	}
}
