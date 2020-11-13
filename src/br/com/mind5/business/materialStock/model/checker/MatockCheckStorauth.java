package br.com.mind5.business.materialStock.model.checker;

import br.com.mind5.authorization.storeAuthorization.info.StorauthInfo;
import br.com.mind5.authorization.storeAuthorization.model.checker.StorauthCheckExist;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class MatockCheckStorauth extends ModelCheckerTemplateForward<MatockInfo, StorauthInfo> {
	
	public MatockCheckStorauth(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<StorauthInfo> getCheckerHook(ModelCheckerOption option) {
		return new StorauthCheckExist(option);
	}
	
	
	
	@Override protected StorauthInfo toForwardClass(MatockInfo baseRecord) {
		return StorauthInfo.copyFrom(baseRecord);
	}
}
