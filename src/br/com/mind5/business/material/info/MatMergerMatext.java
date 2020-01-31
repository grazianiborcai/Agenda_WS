package br.com.mind5.business.material.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatMergerMatext extends InfoMergerTemplate_<MatInfo, MatextInfo> {

	@Override protected InfoMergerVisitor_<MatInfo, MatextInfo> getVisitorHook() {
		return new MatVisiMergeMatext();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
