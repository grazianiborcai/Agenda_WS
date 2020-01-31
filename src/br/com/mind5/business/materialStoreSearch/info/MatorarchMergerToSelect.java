package br.com.mind5.business.materialStoreSearch.info;

import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatorarchMergerToSelect extends InfoMergerTemplate_<MatorarchInfo, MatorarchInfo> {

	@Override protected InfoMergerVisitor_<MatorarchInfo, MatorarchInfo> getVisitorHook() {
		return new MatorarchVisiMergeToSelect();
	}
}
