package br.com.mind5.business.materialSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatarchMergerToSelect extends InfoMergerTemplate_<MatarchInfo, MatarchInfo> {

	@Override protected InfoMergerVisitor_<MatarchInfo, MatarchInfo> getVisitorHook() {
		return new MatarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatarchInfo> getUniquifierHook() {
		return new MatarchUniquifier();
	}
}
