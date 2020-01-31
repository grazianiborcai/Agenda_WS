package br.com.mind5.business.materialTextDefault.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatextaultMergerToSelect extends InfoMergerTemplate_<MatextaultInfo, MatextaultInfo> {

	@Override protected InfoMergerVisitor_<MatextaultInfo, MatextaultInfo> getVisitorHook() {
		return new MatextaultVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatextaultInfo> getUniquifierHook() {
		return new MatextaultUniquifier();
	}
}
