package br.com.mind5.business.materialStockSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatocarchMergerToSelect extends InfoMergerTemplate<MatocarchInfo, MatocarchInfo> {

	@Override protected InfoMergerVisitor<MatocarchInfo, MatocarchInfo> getVisitorHook() {
		return new MatocarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatocarchInfo> getUniquifierHook() {
		return new MatocarchUniquifier();
	}
}
