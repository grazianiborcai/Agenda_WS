package br.com.mind5.business.material.info;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatMergerMatType extends InfoMergerTemplate<MatInfo, MatTypeInfo> {

	@Override protected InfoMergerVisitor<MatInfo, MatTypeInfo> getVisitorHook() {
		return new MatVisiMergeMatType();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
