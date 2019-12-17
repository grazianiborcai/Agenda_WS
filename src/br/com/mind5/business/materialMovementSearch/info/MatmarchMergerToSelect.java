package br.com.mind5.business.materialMovementSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;


final class MatmarchMergerToSelect extends InfoMergerTemplate<MatmarchInfo, MatmarchInfo> {

	@Override protected InfoMergerVisitor<MatmarchInfo, MatmarchInfo> getVisitorHook() {
		return new MatmarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatmarchInfo> getUniquifierHook() {
		return new MatmarchUniquifier();
	}
}
