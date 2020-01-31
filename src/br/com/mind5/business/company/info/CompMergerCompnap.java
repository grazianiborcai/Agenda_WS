package br.com.mind5.business.company.info;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CompMergerCompnap extends InfoMergerTemplate_<CompInfo, CompnapInfo> {

	@Override protected InfoMergerVisitor_<CompInfo, CompnapInfo> getVisitorHook() {
		return new CompVisiMergeCompnap();
	}
	
	
	
	@Override protected InfoUniquifier<CompInfo> getUniquifierHook() {
		return new CompUniquifier();
	}
}
