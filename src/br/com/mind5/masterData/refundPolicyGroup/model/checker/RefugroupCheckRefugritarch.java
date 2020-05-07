package br.com.mind5.masterData.refundPolicyGroup.model.checker;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.info.RefugritarchInfo;
import br.com.mind5.masterData.refundPolicyGroupItemSearch.model.checker.RefugritarchCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class RefugroupCheckRefugritarch extends ModelCheckerTemplateForwardV2<RefugroupInfo, RefugritarchInfo> {
	
	public RefugroupCheckRefugritarch(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<RefugritarchInfo> getCheckerHook(ModelCheckerOption option) {
		return new RefugritarchCheckExist(option);
	}
	
	
	
	@Override protected RefugritarchInfo toForwardClass(RefugroupInfo baseRecord) {
		return RefugritarchInfo.copyFrom(baseRecord);
	}
}
