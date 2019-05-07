package br.com.gda.business.materialStore.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;

final class MatoreMergerMat extends InfoMergerTemplate<MatoreInfo, MatInfo> {

	@Override protected InfoMergerVisitorV2<MatoreInfo, MatInfo> getVisitorHook() {
		return new MatoreVisiMergeMat();
	}
}
