package br.com.mind5.business.materialMovement.model.checker;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.material.model.checker.MatCheckExist;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatmovCheckMat extends ModelCheckerTemplateForwardV2<MatmovInfo, MatInfo> {
	
	public MatmovCheckMat(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatCheckExist(option);
	}
	
	
	
	@Override protected MatInfo toForwardClass(MatmovInfo baseRecord) {
		return MatInfo.copyFrom(baseRecord);
	}
}
