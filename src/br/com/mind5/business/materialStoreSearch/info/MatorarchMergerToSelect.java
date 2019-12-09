package br.com.mind5.business.materialStoreSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class MatorarchMergerToSelect extends InfoMergerTemplate<MatorarchInfo, MatorarchInfo> {

	@Override protected InfoMergerVisitor<MatorarchInfo, MatorarchInfo> getVisitorHook() {
		return new MatorarchVisiMergeToSelect();
	}
}
