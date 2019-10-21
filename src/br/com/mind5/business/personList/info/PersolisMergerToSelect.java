package br.com.mind5.business.personList.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class PersolisMergerToSelect extends InfoMergerTemplate<PersolisInfo, PersolisInfo> {

	@Override protected InfoMergerVisitor<PersolisInfo, PersolisInfo> getVisitorHook() {
		return new PersolisVisiMergeToSelect();
	}
}
