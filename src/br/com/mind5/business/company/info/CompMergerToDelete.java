package br.com.mind5.business.company.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CompMergerToDelete extends InfoMergerTemplate_<CompInfo, CompInfo> {
	
	@Override protected InfoMergerVisitor_<CompInfo, CompInfo> getVisitorHook() {
		return new CompVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<CompInfo> getUniquifierHook() {
		return new CompUniquifier();
	}
}
