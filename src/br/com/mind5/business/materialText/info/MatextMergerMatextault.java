package br.com.mind5.business.materialText.info;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatextMergerMatextault extends InfoMergerTemplate<MatextInfo, MatextaultInfo> {

	@Override protected InfoMergerVisitor<MatextInfo, MatextaultInfo> getVisitorHook() {
		return new MatextVisiMergeMatextault();
	}
	
	
	
	@Override protected InfoUniquifier<MatextInfo> getUniquifierHook() {
		return new MatextUniquifier();
	}
}
