package br.com.mind5.business.material.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatCheckMatore extends ModelCheckerTemplateForward<MatInfo, MatoreInfo> {
	
	public MatCheckMatore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoreCheckExist(option);
	}
	
	
	
	@Override protected MatoreInfo toForwardClass(MatInfo baseRecord) {
		return MatoreInfo.copyFrom(baseRecord);
	}
}
