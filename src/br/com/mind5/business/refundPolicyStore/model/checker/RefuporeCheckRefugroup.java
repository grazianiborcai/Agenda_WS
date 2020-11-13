package br.com.mind5.business.refundPolicyStore.model.checker;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroup.model.checker.RefugroupCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForward;
import br.com.mind5.model.checker.ModelChecker;

public final class RefuporeCheckRefugroup extends ModelCheckerTemplateForward<RefuporeInfo, RefugroupInfo> {
	
	public RefuporeCheckRefugroup(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelChecker<RefugroupInfo> getCheckerHook(ModelCheckerOption option) {
		return new RefugroupCheckExist(option);
	}
	
	
	
	@Override protected RefugroupInfo toForwardClass(RefuporeInfo baseRecord) {
		return RefugroupInfo.copyFrom(baseRecord);
	}
}
