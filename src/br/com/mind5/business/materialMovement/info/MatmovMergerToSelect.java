package br.com.mind5.business.materialMovement.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;


final class MatmovMergerToSelect extends InfoMergerTemplate<MatmovInfo, MatmovInfo> {

	@Override protected InfoMergerVisitor<MatmovInfo, MatmovInfo> getVisitorHook() {
		return new MatmovVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
