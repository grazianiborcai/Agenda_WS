package br.com.mind5.business.materialText.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatextCheckMat extends ModelCheckerTemplateForward<MatextInfo, MatInfo> {

	public MatextCheckMat(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected ModelChecker<MatInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatCheckExist(option);
	}
	
	
	
	@Override protected MatInfo toForwardClass(MatextInfo baseRecord) {
		return MatInfo.copyFrom(baseRecord);
	}
}
