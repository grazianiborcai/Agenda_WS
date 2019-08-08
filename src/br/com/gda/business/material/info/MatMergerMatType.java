package br.com.gda.business.material.info;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class MatMergerMatType extends InfoMergerTemplate<MatInfo, MatTypeInfo> {

	@Override protected InfoMergerVisitor<MatInfo, MatTypeInfo> getVisitorHook() {
		return new MatVisiMergeMatType();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
