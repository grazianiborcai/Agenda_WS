package br.com.gda.business.companySnapshot.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class CompnapMergerToSelect extends InfoMergerTemplate<CompnapInfo, CompnapInfo> {

	@Override protected InfoMergerVisitor<CompnapInfo, CompnapInfo> getVisitorHook() {
		return new CompnapVisiMergeToSelect();
	}
}
