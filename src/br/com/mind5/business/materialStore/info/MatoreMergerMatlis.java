package br.com.mind5.business.materialStore.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatoreMergerMatlis extends InfoMergerTemplate<MatoreInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, MatlisInfo> getVisitorHook() {
		return new MatoreVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}	
}
