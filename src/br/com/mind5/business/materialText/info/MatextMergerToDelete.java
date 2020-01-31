package br.com.mind5.business.materialText.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatextMergerToDelete extends InfoMergerTemplate_<MatextInfo, MatextInfo> {

	@Override protected InfoMergerVisitor_<MatextInfo, MatextInfo> getVisitorHook() {
		return new MatextVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<MatextInfo> getUniquifierHook() {
		return new MatextUniquifier();
	}
}
