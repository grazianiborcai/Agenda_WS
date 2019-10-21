package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class MatoreMergerMatock extends InfoMergerTemplate<MatoreInfo, MatockInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, MatockInfo> getVisitorHook() {
		return new MatoreVisiMergeMatock();
	}
}
