package br.com.gda.business.personList.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;

final class PersolisMergerToSelect extends InfoMergerTemplate<PersolisInfo, PersolisInfo> {

	@Override protected InfoMergerVisitorV2<PersolisInfo, PersolisInfo> getVisitorHook() {
		return new PersolisVisiMergeToSelect();
	}
}
