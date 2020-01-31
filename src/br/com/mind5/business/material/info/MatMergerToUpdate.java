package br.com.mind5.business.material.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatMergerToUpdate extends InfoMergerTemplate_<MatInfo, MatInfo> {

	@Override protected InfoMergerVisitor_<MatInfo, MatInfo> getVisitorHook() {
		return new MatVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
