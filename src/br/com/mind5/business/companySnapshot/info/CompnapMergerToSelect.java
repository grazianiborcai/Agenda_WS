package br.com.mind5.business.companySnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class CompnapMergerToSelect extends InfoMergerTemplate<CompnapInfo, CompnapInfo> {

	@Override protected InfoMergerVisitor<CompnapInfo, CompnapInfo> getVisitorHook() {
		return new CompnapVisiMergeToSelect();
	}
}
