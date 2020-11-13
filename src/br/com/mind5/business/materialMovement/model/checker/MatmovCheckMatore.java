package br.com.mind5.business.materialMovement.model.checker;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatmovCheckMatore extends ModelCheckerTemplateForward<MatmovInfo, MatoreInfo> {
	
	public MatmovCheckMatore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<MatoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoreCheckExist(option);
	}
	
	
	
	@Override protected MatoreInfo toForwardClass(MatmovInfo baseRecord) {
		return MatoreInfo.copyFrom(baseRecord);
	}
}
