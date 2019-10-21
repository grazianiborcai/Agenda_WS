package br.com.mind5.business.material.info;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatMergerMatCateg extends InfoMergerTemplate<MatInfo, MatCategInfo> {

	@Override protected InfoMergerVisitor<MatInfo, MatCategInfo> getVisitorHook() {
		return new MatVisiMergeMatCateg();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
