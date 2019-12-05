package br.com.mind5.business.materialTextSnapshot.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatextsnapMergerToSelect extends InfoMergerTemplate<MatextsnapInfo, MatextsnapInfo> {

	@Override protected InfoMergerVisitor<MatextsnapInfo, MatextsnapInfo> getVisitorHook() {
		return new MatextsnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatextsnapInfo> getUniquifierHook() {
		return new MatextsnapUniquifier();
	}
}
