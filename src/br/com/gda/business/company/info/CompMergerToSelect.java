package br.com.gda.business.company.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;

final class CompMergerToSelect extends InfoMergerTemplate<CompInfo, CompInfo> {

	@Override protected InfoMergerVisitorV2<CompInfo, CompInfo> getVisitorHook() {
		return new CompVisiMergeToSelect();
	}
}
