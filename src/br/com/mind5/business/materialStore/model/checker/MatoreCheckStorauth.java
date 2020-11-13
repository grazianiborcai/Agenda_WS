package br.com.mind5.business.materialStore.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckExist;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatoreCheckStorauth extends ModelCheckerTemplateForward<MatoreInfo, StorauthInfo> {
	
	public MatoreCheckStorauth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StorauthInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorauthCheckExist(option);
	}
	
	
	
	@Override protected StorauthInfo toForwardClass(MatoreInfo baseRecord) {
		return StorauthInfo.copyFrom(baseRecord);
	}
}
