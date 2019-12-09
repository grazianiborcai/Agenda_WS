package br.com.mind5.business.materialStore.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatoreMergerToSelect extends InfoMergerTemplate<MatoreInfo, MatoreInfo> {

	@Override protected InfoMergerVisitor<MatoreInfo, MatoreInfo> getVisitorHook() {
		return new MatoreVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}	
}
