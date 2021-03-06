package br.com.mind5.payment.payOrderItemSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class StdPayormarchEnforceReverted extends ActionStdTemplate<PayormarchInfo> {

	public StdPayormarchEnforceReverted(DeciTreeOption<PayormarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PayormarchInfo> buildVisitorHook(DeciTreeOption<PayormarchInfo> option) {
		return new VisiPayormarchEnforceReverted(option);
	}
}
