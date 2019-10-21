package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class MatoreMergerMat extends InfoMergerTemplate<MatoreInfo, MatInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, MatInfo> getVisitorHook() {
		return new MatoreVisiMergeMat();
	}
}
