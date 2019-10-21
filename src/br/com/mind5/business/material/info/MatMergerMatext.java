package br.com.mind5.business.material.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatMergerMatext extends InfoMergerTemplate<MatInfo, MatextInfo> {

	@Override protected InfoMergerVisitor<MatInfo, MatextInfo> getVisitorHook() {
		return new MatVisiMergeMatext();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
