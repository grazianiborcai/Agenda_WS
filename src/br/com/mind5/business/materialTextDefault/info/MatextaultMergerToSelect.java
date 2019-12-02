package br.com.mind5.business.materialTextDefault.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatextaultMergerToSelect extends InfoMergerTemplate<MatextaultInfo, MatextaultInfo> {

	@Override protected InfoMergerVisitor<MatextaultInfo, MatextaultInfo> getVisitorHook() {
		return new MatextaultVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatextaultInfo> getUniquifierHook() {
		return new MatextaultUniquifier();
	}
}
