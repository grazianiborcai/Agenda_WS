package br.com.mind5.authorization.customerAuthorization.model.checker;

import br.com.mind5.authorization.customerAuthorization.info.CusauthInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistManager;

public final class CusauthCheckAuthManager extends ModelCheckerTemplateForwardV2<CusauthInfo, UserarchInfo> {
	
	public CusauthCheckAuthManager(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistManager(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(CusauthInfo baseRecord) {
		return UserarchCopier.copyFromCusauth(baseRecord);
	}
}
