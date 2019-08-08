package br.com.gda.business.materialTextSnapshot.info;

import br.com.gda.business.materialText.info.MatextInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class MatextsnapMergerMatext extends InfoMergerTemplate<MatextsnapInfo, MatextInfo> {

	@Override protected InfoMergerVisitor<MatextsnapInfo, MatextInfo> getVisitorHook() {
		return new MatextsnapVisiMergeMatext();
	}
	
	
	
	@Override protected InfoUniquifier<MatextsnapInfo> getUniquifierHook() {
		return new MatextsnapUniquifier();
	}
}
