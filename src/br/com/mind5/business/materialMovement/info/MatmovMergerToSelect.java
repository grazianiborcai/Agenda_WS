package br.com.mind5.business.materialMovement.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;


final class MatmovMergerToSelect extends InfoMergerTemplate_<MatmovInfo, MatmovInfo> {

	@Override protected InfoMergerVisitor_<MatmovInfo, MatmovInfo> getVisitorHook() {
		return new MatmovVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
