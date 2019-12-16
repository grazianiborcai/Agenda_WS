package br.com.mind5.business.materialMovement.info;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatmovMergerMatock extends InfoMergerTemplate<MatmovInfo, MatockInfo> {

	@Override protected InfoMergerVisitor<MatmovInfo, MatockInfo> getVisitorHook() {
		return new MatmovVisiMergeMatock();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
