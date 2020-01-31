package br.com.mind5.business.material.info;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatMergerMatsnap extends InfoMergerTemplate_<MatInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitor_<MatInfo, MatsnapInfo> getVisitorHook() {
		return new MatVisiMergeMatsnap();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
