package br.com.gda.business.materialMovement.info;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class MatmovMergerMat extends InfoMergerTemplate<MatmovInfo, MatInfo> {

	@Override protected InfoMergerVisitor<MatmovInfo, MatInfo> getVisitorHook() {
		return new MatmovVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
