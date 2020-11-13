package br.com.mind5.business.materialStock.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatockCheckMat extends ModelCheckerTemplateForward<MatockInfo, MatInfo> {
	
	public MatockCheckMat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatCheckExist(option);
	}
	
	
	
	@Override protected MatInfo toForwardClass(MatockInfo baseRecord) {
		return MatInfo.copyFrom(baseRecord);
	}
}
