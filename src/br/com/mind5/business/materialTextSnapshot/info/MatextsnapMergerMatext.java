package br.com.mind5.business.materialTextSnapshot.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatextsnapMergerMatext extends InfoMergerTemplate_<MatextsnapInfo, MatextInfo> {

	@Override protected InfoMergerVisitor_<MatextsnapInfo, MatextInfo> getVisitorHook() {
		return new MatextsnapVisiMergeMatext();
	}
	
	
	
	@Override protected InfoUniquifier<MatextsnapInfo> getUniquifierHook() {
		return new MatextsnapUniquifier();
	}
}
