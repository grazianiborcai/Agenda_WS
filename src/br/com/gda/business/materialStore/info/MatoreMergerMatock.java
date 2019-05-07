package br.com.gda.business.materialStore.info;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;

final class MatoreMergerMatock extends InfoMergerTemplate<MatoreInfo, MatockInfo> {

	@Override protected InfoMergerVisitorV2<MatoreInfo, MatockInfo> getVisitorHook() {
		return new MatoreVisiMergeMatock();
	}
}
