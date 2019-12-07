package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class MatoreMergerMatlis extends InfoMergerTemplate<MatoreInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, MatlisInfo> getVisitorHook() {
		return new MatoreVisiMergeMatlis();
	}
}
