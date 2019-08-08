package br.com.gda.business.materialMovement.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;


final class MatmovMergerToDelete extends InfoMergerTemplate<MatmovInfo, MatmovInfo> {

	@Override protected InfoMergerVisitor<MatmovInfo, MatmovInfo> getVisitorHook() {
		return new MatmovVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
