package br.com.mind5.business.materialStore.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatoreMergerToSelect extends InfoMergerTemplate_<MatoreInfo, MatoreInfo> {

	@Override protected InfoMergerVisitor_<MatoreInfo, MatoreInfo> getVisitorHook() {
		return new MatoreVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatoreInfo> getUniquifierHook() {
		return new MatoreUniquifier();
	}	
}
