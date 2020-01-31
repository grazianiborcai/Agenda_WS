package br.com.mind5.business.companySnapshot.info;

import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CompnapMergerToSelect extends InfoMergerTemplate_<CompnapInfo, CompnapInfo> {

	@Override protected InfoMergerVisitor_<CompnapInfo, CompnapInfo> getVisitorHook() {
		return new CompnapVisiMergeToSelect();
	}
}
