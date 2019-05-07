package br.com.gda.business.material.info;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class MatMergerMatext extends InfoMergerTemplate<MatInfo, MatextInfo> {

	@Override protected InfoMergerVisitorV2<MatInfo, MatextInfo> getVisitorHook() {
		return new MatVisiMergeMatext();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
