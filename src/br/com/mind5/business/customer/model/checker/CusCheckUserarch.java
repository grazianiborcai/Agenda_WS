package br.com.mind5.business.customer.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistUsername;

public final class CusCheckUserarch extends ModelCheckerTemplateForward<CusInfo, UserarchInfo> {
	
	public CusCheckUserarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistUsername(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(CusInfo baseRecord) {
		return UserarchCopier.copyFromCus(baseRecord);
	}
}
