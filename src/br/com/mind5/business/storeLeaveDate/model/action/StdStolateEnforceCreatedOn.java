package br.com.mind5.business.storeLeaveDate.model.action;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdStolateEnforceCreatedOn extends ActionStdTemplateV2<StolateInfo> {

	public StdStolateEnforceCreatedOn(DeciTreeOption<StolateInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<StolateInfo> buildVisitorHook(DeciTreeOption<StolateInfo> option) {
		return new VisiStolateEnforceCreatedOn(option);
	}
}
