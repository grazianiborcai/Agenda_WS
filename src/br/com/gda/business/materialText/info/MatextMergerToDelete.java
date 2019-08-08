package br.com.gda.business.materialText.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class MatextMergerToDelete extends InfoMergerTemplate<MatextInfo, MatextInfo> {

	@Override protected InfoMergerVisitor<MatextInfo, MatextInfo> getVisitorHook() {
		return new MatextVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<MatextInfo> getUniquifierHook() {
		return new MatextUniquifier();
	}
}
