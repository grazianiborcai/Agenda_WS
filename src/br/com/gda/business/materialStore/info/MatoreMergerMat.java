package br.com.gda.business.materialStore.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class MatoreMergerMat extends InfoMergerTemplate<MatoreInfo, MatInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, MatInfo> getVisitorHook() {
		return new MatoreVisiMergeMat();
	}
}
