package br.com.mind5.business.material.info;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatMergerMatsnap extends InfoMergerTemplate<MatInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitor<MatInfo, MatsnapInfo> getVisitorHook() {
		return new MatVisiMergeMatsnap();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
