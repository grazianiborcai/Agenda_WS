package br.com.mind5.business.materialMovement.info;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatmovMergerMat extends InfoMergerTemplate<MatmovInfo, MatInfo> {

	@Override protected InfoMergerVisitor<MatmovInfo, MatInfo> getVisitorHook() {
		return new MatmovVisiMergeMat();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
