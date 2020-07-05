package br.com.mind5.business.customer.model.checker;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.user.info.UserCopier;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.checker.UserCheckExist;

public final class CusCheckUser extends ModelCheckerTemplateForwardV2<CusInfo, UserInfo> {
	
	public CusCheckUser(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserCheckExist(option);
	}
	
	
	
	@Override protected UserInfo toForwardClass(CusInfo baseRecord) {
		return UserCopier.copyFromCusKey(baseRecord);
	}
}
