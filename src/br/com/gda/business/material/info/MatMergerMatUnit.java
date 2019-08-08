package br.com.gda.business.material.info;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class MatMergerMatUnit extends InfoMergerTemplate<MatInfo, MatUnitInfo> {

	@Override protected InfoMergerVisitor<MatInfo, MatUnitInfo> getVisitorHook() {
		return new MatVisiMergeMatUnit();
	}
	
	
	
	@Override protected InfoUniquifier<MatInfo> getUniquifierHook() {
		return new MatUniquifier();
	}
}
