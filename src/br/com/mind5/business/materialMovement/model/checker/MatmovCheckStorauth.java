package br.com.mind5.business.materialMovement.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckExist;
import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatmovCheckStorauth extends ModelCheckerTemplateForward<MatmovInfo, StorauthInfo> {
	
	public MatmovCheckStorauth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StorauthInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorauthCheckExist(option);
	}
	
	
	
	@Override protected StorauthInfo toForwardClass(MatmovInfo baseRecord) {
		return StorauthInfo.copyFrom(baseRecord);
	}
}
