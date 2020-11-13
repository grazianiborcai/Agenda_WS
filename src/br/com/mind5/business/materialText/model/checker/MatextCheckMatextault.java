package br.com.mind5.business.materialText.model.checker;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextDefault.model.checker.MatextaultCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatextCheckMatextault extends ModelCheckerTemplateForward<MatextInfo, MatextaultInfo> {
	
	public MatextCheckMatextault(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatextaultInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatextaultCheckExist(option);
	}
	
	
	
	@Override protected MatextaultInfo toForwardClass(MatextInfo baseRecord) {
		return MatextaultInfo.copyFrom(baseRecord);
	}
}
