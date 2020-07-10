package br.com.mind5.business.customer.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistUsername;

public final class CusCheckUserarch extends ModelCheckerTemplateForwardV2<CusInfo, UserarchInfo> {
	
	public CusCheckUserarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistUsername(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(CusInfo baseRecord) {
		return UserarchCopier.copyFromCus(baseRecord);
	}
}
