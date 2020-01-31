package br.com.mind5.business.material.info;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatMergerMatCateg extends InfoMergerTemplate_<MatInfo, MatCategInfo> {

	@Override protected InfoMergerVisitor_<MatInfo, MatCategInfo> getVisitorHook() {
		return new MatVisiMergeMatCateg();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
