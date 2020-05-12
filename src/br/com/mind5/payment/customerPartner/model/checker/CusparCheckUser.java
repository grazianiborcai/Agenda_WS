package br.com.mind5.payment.customerPartner.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.user.model.checker.UserCheckExist;

public final class CusparCheckUser extends ModelCheckerTemplateForwardV2<CusparInfo, UserInfo> {
	
	public CusparCheckUser(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserCheckExist(option);
	}
	
	
	
	@Override protected UserInfo toForwardClass(CusparInfo baseRecord) {
		return UserInfo.copyFrom(baseRecord);
	}
}
