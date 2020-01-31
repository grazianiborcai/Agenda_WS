package br.com.mind5.business.materialMovement.info;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatmovMergerMatmarch extends InfoMergerTemplate_<MatmovInfo, MatmarchInfo> {

	@Override protected InfoMergerVisitor_<MatmovInfo, MatmarchInfo> getVisitorHook() {
		return new MatmovVisiMergeMatmarch();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
