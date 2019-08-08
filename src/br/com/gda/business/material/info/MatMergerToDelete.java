package br.com.gda.business.material.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class MatMergerToDelete extends InfoMergerTemplate<MatInfo, MatInfo> {

	@Override protected InfoMergerVisitor<MatInfo, MatInfo> getVisitorHook() {
		return new MatVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
