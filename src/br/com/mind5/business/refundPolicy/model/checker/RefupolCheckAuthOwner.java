package br.com.mind5.business.refundPolicy.model.checker;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistOwner;

public final class RefupolCheckAuthOwner extends ModelCheckerTemplateForward<RefupolInfo, UserarchInfo> {
	
	public RefupolCheckAuthOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistOwner(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(RefupolInfo baseRecord) {
		return UserarchCopier.copyFromRefupol(baseRecord);
	}
}
