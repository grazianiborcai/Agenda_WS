package br.com.mind5.business.materialTextSnapshot.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatextsnapMergerToSelect extends InfoMergerTemplate_<MatextsnapInfo, MatextsnapInfo> {

	@Override protected InfoMergerVisitor_<MatextsnapInfo, MatextsnapInfo> getVisitorHook() {
		return new MatextsnapVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<MatextsnapInfo> getUniquifierHook() {
		return new MatextsnapUniquifier();
	}
}
