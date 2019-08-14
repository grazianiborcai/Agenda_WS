package br.com.gda.business.company.info;

import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class CompMergerCompnap extends InfoMergerTemplate<CompInfo, CompnapInfo> {

	@Override protected InfoMergerVisitor<CompInfo, CompnapInfo> getVisitorHook() {
		return new CompVisiMergeCompnap();
	}
}
