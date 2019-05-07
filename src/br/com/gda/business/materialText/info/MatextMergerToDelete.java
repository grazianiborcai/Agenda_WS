package br.com.gda.business.materialText.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class MatextMergerToDelete extends InfoMergerTemplate<MatextInfo, MatextInfo> {

	@Override protected InfoMergerVisitorV2<MatextInfo, MatextInfo> getVisitorHook() {
		return new MatextVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<MatextInfo> getUniquifierHook() {
		return new MatextUniquifier();
	}
}
