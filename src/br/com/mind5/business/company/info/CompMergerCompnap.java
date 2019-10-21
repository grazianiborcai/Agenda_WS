package br.com.mind5.business.company.info;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CompMergerCompnap extends InfoMergerTemplate<CompInfo, CompnapInfo> {

	@Override protected InfoMergerVisitor<CompInfo, CompnapInfo> getVisitorHook() {
		return new CompVisiMergeCompnap();
	}
	
	
	
	@Override protected InfoUniquifier<CompInfo> getUniquifierHook() {
		return new CompUniquifier();
	}
}
