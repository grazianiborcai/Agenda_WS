package br.com.gda.business.material.info;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class MatMergerMatsnap extends InfoMergerTemplate<MatInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitor<MatInfo, MatsnapInfo> getVisitorHook() {
		return new MatVisiMergeMatsnap();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
