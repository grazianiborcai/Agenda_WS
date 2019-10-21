package br.com.mind5.business.materialStore.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class MatoreMergerToDelete extends InfoMergerTemplate<MatoreInfo, MatoreInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, MatoreInfo> getVisitorHook() {
		return new MatoreVisiMergeToDelete();
	}
}
