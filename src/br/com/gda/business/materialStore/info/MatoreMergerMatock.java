package br.com.gda.business.materialStore.info;

import br.com.gda.business.materialStock.info.MatockInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class MatoreMergerMatock extends InfoMergerTemplate<MatoreInfo, MatockInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, MatockInfo> getVisitorHook() {
		return new MatoreVisiMergeMatock();
	}
}
