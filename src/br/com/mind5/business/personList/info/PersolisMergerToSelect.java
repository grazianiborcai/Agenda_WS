package br.com.mind5.business.personList.info;

import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PersolisMergerToSelect extends InfoMergerTemplate_<PersolisInfo, PersolisInfo> {

	@Override protected InfoMergerVisitor_<PersolisInfo, PersolisInfo> getVisitorHook() {
		return new PersolisVisiMergeToSelect();
	}
}
