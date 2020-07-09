package br.com.mind5.authorization.customerAuthorization.model.checker;

import br.com.mind5.authorization.customerAuthorization.info.CusauthInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistOwner;

public final class CusauthCheckAuthOwner extends ModelCheckerTemplateForwardV2<CusauthInfo, UserarchInfo> {
	
	public CusauthCheckAuthOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistOwner(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(CusauthInfo baseRecord) {
		return UserarchCopier.copyFromCusauth(baseRecord);
	}
}
