package br.com.mind5.payment.refundOrderItem.model.checker;

import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.payment.refundOrderItem.info.RefemInfo;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistOwner;

public final class RefemCheckAuthOwner extends ModelCheckerTemplateForward<RefemInfo, UserarchInfo> {
	
	public RefemCheckAuthOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistOwner(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(RefemInfo baseRecord) {
		return UserarchCopier.copyFromRefem(baseRecord);
	}
}
