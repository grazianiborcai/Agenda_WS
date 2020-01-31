package br.com.mind5.business.materialMovement.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatmovMergerMatlis extends InfoMergerTemplate_<MatmovInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor_<MatmovInfo, MatlisInfo> getVisitorHook() {
		return new MatmovVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
