package br.com.gda.business.material.info;

import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class MatMergerMatType extends InfoMergerTemplate<MatInfo, MatTypeInfo> {

	@Override protected InfoMergerVisitorV2<MatInfo, MatTypeInfo> getVisitorHook() {
		return new MatVisiMergeMatType();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
