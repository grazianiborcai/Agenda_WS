package br.com.mind5.business.material.info;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatMergerMatUnit extends InfoMergerTemplate<MatInfo, MatUnitInfo> {

	@Override protected InfoMergerVisitor<MatInfo, MatUnitInfo> getVisitorHook() {
		return new MatVisiMergeMatUnit();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
