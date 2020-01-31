package br.com.mind5.business.materialText.info;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatextMergerMatextault extends InfoMergerTemplate_<MatextInfo, MatextaultInfo> {

	@Override protected InfoMergerVisitor_<MatextInfo, MatextaultInfo> getVisitorHook() {
		return new MatextVisiMergeMatextault();
	}
	
	
	
	@Override protected InfoUniquifier<MatextInfo> getUniquifierHook() {
		return new MatextUniquifier();
	}
}
