package br.com.gda.business.personList.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class PersolisMergerToSelect extends InfoMergerTemplate<PersolisInfo, PersolisInfo> {

	@Override protected InfoMergerVisitor<PersolisInfo, PersolisInfo> getVisitorHook() {
		return new PersolisVisiMergeToSelect();
	}
}
