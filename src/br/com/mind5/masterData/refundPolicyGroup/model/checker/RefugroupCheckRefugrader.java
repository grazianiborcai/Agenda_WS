package br.com.mind5.masterData.refundPolicyGroup.model.checker;

import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.masterData.refundPolicyGroupHeader.info.RefugraderInfo;
import br.com.mind5.masterData.refundPolicyGroupHeader.model.checker.RefugraderCheckExist;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateForwardV2;
import br.com.mind5.model.checker.ModelCheckerV1;

public final class RefugroupCheckRefugrader extends ModelCheckerTemplateForwardV2<RefugroupInfo, RefugraderInfo> {
	
	public RefugroupCheckRefugrader(ModelCheckerOption option) {
		super(option);
	}


	
	@Override protected ModelCheckerV1<RefugraderInfo> getCheckerHook(ModelCheckerOption option) {
		return new RefugraderCheckExist(option);
	}
	
	
	
	@Override protected RefugraderInfo toForwardClass(RefugroupInfo baseRecord) {
		return RefugraderInfo.copyFrom(baseRecord);
	}
}
