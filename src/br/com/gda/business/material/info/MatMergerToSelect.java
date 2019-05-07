package br.com.gda.business.material.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class MatMergerToSelect extends InfoMergerTemplate<MatInfo, MatInfo> {

	@Override protected InfoMergerVisitorV2<MatInfo, MatInfo> getVisitorHook() {
		return new MatVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
