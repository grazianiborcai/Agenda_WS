package br.com.mind5.business.material.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatMergerToUpdate extends InfoMergerTemplate<MatInfo, MatInfo> {

	@Override protected InfoMergerVisitor<MatInfo, MatInfo> getVisitorHook() {
		return new MatVisiMergeToUpdate();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
