package br.com.mind5.business.refundPolicyOwner.model.checker;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.checker.RefugroupCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class RefupownCheckRefugroup extends ModelCheckerTemplateForward<RefupownInfo, RefugroupInfo> {
	
	public RefupownCheckRefugroup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<RefugroupInfo> getCheckerHook(ModelCheckerOption option) {
		return new RefugroupCheckExist(option);
	}
	
	
	
	@Override protected RefugroupInfo toForwardClass(RefupownInfo baseRecord) {
		return RefugroupInfo.copyFrom(baseRecord);
	}
}
