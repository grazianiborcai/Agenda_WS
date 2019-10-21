package br.com.mind5.business.materialTextSnapshot.info;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatextsnapMergerMatext extends InfoMergerTemplate<MatextsnapInfo, MatextInfo> {

	@Override protected InfoMergerVisitor<MatextsnapInfo, MatextInfo> getVisitorHook() {
		return new MatextsnapVisiMergeMatext();
	}
	
	
	
	@Override protected InfoUniquifier<MatextsnapInfo> getUniquifierHook() {
		return new MatextsnapUniquifier();
	}
}
