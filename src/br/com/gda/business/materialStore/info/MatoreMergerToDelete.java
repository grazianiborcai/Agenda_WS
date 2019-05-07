package br.com.gda.business.materialStore.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;

final class MatoreMergerToDelete extends InfoMergerTemplate<MatoreInfo, MatoreInfo> {

	@Override protected InfoMergerVisitorV2<MatoreInfo, MatoreInfo> getVisitorHook() {
		return new MatoreVisiMergeToDelete();
	}
}
