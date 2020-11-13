package br.com.mind5.business.materialMovement.model.checker;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.materialStore.model.checker.MatoreCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class MatmovCheckMatore extends ModelCheckerTemplateForwardV2<MatmovInfo, MatoreInfo> {
	
	public MatmovCheckMatore(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<MatoreInfo> getCheckerHook(ModelCheckerOption option) {
		return new MatoreCheckExist(option);
	}
	
	
	
	@Override protected MatoreInfo toForwardClass(MatmovInfo baseRecord) {
		return MatoreInfo.copyFrom(baseRecord);
	}
}
