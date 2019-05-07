package br.com.gda.business.material.info;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class MatMergerMatCateg extends InfoMergerTemplate<MatInfo, MatCategInfo> {

	@Override protected InfoMergerVisitorV2<MatInfo, MatCategInfo> getVisitorHook() {
		return new MatVisiMergeMatCateg();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
