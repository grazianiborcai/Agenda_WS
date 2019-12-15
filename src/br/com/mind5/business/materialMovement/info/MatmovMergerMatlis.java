package br.com.mind5.business.materialMovement.info;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatmovMergerMatlis extends InfoMergerTemplate<MatmovInfo, MatlisInfo> {

	@Override protected InfoMergerVisitor<MatmovInfo, MatlisInfo> getVisitorHook() {
		return new MatmovVisiMergeMatlis();
	}
	
	
	
	@Override protected InfoUniquifier<MatmovInfo> getUniquifierHook() {
		return new MatmovUniquifier();
	}
}
