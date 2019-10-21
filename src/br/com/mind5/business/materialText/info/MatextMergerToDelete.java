package br.com.mind5.business.materialText.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatextMergerToDelete extends InfoMergerTemplate<MatextInfo, MatextInfo> {

	@Override protected InfoMergerVisitor<MatextInfo, MatextInfo> getVisitorHook() {
		return new MatextVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<MatextInfo> getUniquifierHook() {
		return new MatextUniquifier();
	}
}
