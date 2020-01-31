package br.com.mind5.business.material.info;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatMergerMatUnit extends InfoMergerTemplate_<MatInfo, MatUnitInfo> {

	@Override protected InfoMergerVisitor_<MatInfo, MatUnitInfo> getVisitorHook() {
		return new MatVisiMergeMatUnit();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
