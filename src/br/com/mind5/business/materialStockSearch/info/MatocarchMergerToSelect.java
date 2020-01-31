package br.com.mind5.business.materialStockSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatocarchMergerToSelect extends InfoMergerTemplate_<MatocarchInfo, MatocarchInfo> {

	@Override protected InfoMergerVisitor_<MatocarchInfo, MatocarchInfo> getVisitorHook() {
		return new MatocarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatocarchInfo> getUniquifierHook() {
		return new MatocarchUniquifier();
	}
}
