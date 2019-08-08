package br.com.gda.business.materialMovement.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;


final class MatmovMergerToSelect extends InfoMergerTemplate<MatmovInfo, MatmovInfo> {

	@Override protected InfoMergerVisitor<MatmovInfo, MatmovInfo> getVisitorHook() {
		return new MatmovVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
