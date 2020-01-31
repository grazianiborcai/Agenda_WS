package br.com.mind5.business.material.info;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatMergerMatType extends InfoMergerTemplate_<MatInfo, MatTypeInfo> {

	@Override protected InfoMergerVisitor_<MatInfo, MatTypeInfo> getVisitorHook() {
		return new MatVisiMergeMatType();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
