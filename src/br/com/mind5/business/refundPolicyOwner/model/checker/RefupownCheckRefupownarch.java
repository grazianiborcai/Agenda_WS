package br.com.mind5.business.refundPolicyOwner.model.checker;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupownarchInfo;
import br.com.mind5.business.refundPolicyOwnerSearch.model.checker.RefupownarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class RefupownCheckRefupownarch extends ModelCheckerTemplateForwardV2<RefupownInfo, RefupownarchInfo> {
	
	public RefupownCheckRefupownarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<RefupownarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new RefupownarchCheckExist(option);
	}
	
	
	
	@Override protected RefupownarchInfo toForwardClass(RefupownInfo baseRecord) {
		return RefupownarchInfo.copyFrom(baseRecord);
	}
}
