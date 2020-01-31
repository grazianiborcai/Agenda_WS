package br.com.mind5.business.materialMovementSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;


final class MatmarchMergerToSelect extends InfoMergerTemplate_<MatmarchInfo, MatmarchInfo> {

	@Override protected InfoMergerVisitor_<MatmarchInfo, MatmarchInfo> getVisitorHook() {
		return new MatmarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatmarchInfo> getUniquifierHook() {
		return new MatmarchUniquifier();
	}
}
