package br.com.mind5.business.refundPolicy.model.checker;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;
import br.com.mind5.security.userSearch.info.UserarchCopier;
import br.com.mind5.security.userSearch.info.UserarchInfo;
import br.com.mind5.security.userSearch.model.checker.UserarchCheckExistOwner;

public final class RefupolCheckAuthOwner extends ModelCheckerTemplateForwardV2<RefupolInfo, UserarchInfo> {
	
	public RefupolCheckAuthOwner(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<UserarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new UserarchCheckExistOwner(option);
	}
	
	
	
	@Override protected UserarchInfo toForwardClass(RefupolInfo baseRecord) {
		return UserarchCopier.copyFromRefupol(baseRecord);
	}
}
