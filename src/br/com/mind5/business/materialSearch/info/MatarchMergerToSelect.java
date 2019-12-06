package br.com.mind5.business.materialSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatarchMergerToSelect extends InfoMergerTemplate<MatarchInfo, MatarchInfo> {

	@Override protected InfoMergerVisitor<MatarchInfo, MatarchInfo> getVisitorHook() {
		return new MatarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatarchInfo> getUniquifierHook() {
		return new MatarchUniquifier();
	}
}
