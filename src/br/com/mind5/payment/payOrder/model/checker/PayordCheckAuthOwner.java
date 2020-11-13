package br.com.mind5.payment.payOrder.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistOwner;

public final class PayordCheckAuthOwner extends ModelCheckerTemplateForward<PayordInfo, UserarchInfo> {
	
	public PayordCheckAuthOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistOwner(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(PayordInfo baseRecord) {
		return UserarchCopier.copyFromPayord(baseRecord);
	}
}
