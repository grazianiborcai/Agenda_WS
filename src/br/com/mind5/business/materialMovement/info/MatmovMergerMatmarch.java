package br.com.mind5.business.materialMovement.info;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatmovMergerMatmarch extends InfoMergerTemplate<MatmovInfo, MatmarchInfo> {

	@Override protected InfoMergerVisitor<MatmovInfo, MatmarchInfo> getVisitorHook() {
		return new MatmovVisiMergeMatmarch();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
