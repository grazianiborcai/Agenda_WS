package br.com.mind5.payment.payOrderItemSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class StdPayormarchEnforceReverted extends ActionStdTemplateV2<PayormarchInfo> {

	public StdPayormarchEnforceReverted(DeciTreeOption<PayormarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PayormarchInfo> buildVisitorHook(DeciTreeOption<PayormarchInfo> option) {
		return new VisiPayormarchEnforceReverted(option);
	}
}
