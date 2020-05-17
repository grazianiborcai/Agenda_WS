package br.com.mind5.business.refundPolicy.model.action;

import br.com.mind5.business.refundPolicy.info.RefupolInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdRefupolEnforceRHour extends ActionStdTemplateV2<RefupolInfo> {

	public StdRefupolEnforceRHour(DeciTreeOption<RefupolInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<RefupolInfo> buildVisitorHook(DeciTreeOption<RefupolInfo> option) {
		return new VisiRefupolEnforceRHour(option);
	}
}