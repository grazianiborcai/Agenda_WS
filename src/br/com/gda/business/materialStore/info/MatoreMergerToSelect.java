package br.com.gda.business.materialStore.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class MatoreMergerToSelect extends InfoMergerTemplate<MatoreInfo, MatoreInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, MatoreInfo> getVisitorHook() {
		return new MatoreVisiMergeToSelect();
	}
}
