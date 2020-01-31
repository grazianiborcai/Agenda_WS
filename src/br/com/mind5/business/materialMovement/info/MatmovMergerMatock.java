package br.com.mind5.business.materialMovement.info;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatmovMergerMatock extends InfoMergerTemplate_<MatmovInfo, MatockInfo> {

	@Override protected InfoMergerVisitor_<MatmovInfo, MatockInfo> getVisitorHook() {
		return new MatmovVisiMergeMatock();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
