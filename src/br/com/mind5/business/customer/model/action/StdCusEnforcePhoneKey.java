package br.com.mind5.business.customer.model.action;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusEnforcePhoneKey extends ActionStdTemplate<CusInfo> {

	public StdCusEnforcePhoneKey(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CusInfo> buildVisitorHook(DeciTreeOption<CusInfo> option) {
		return new VisiCusEnforcePhoneKey(option);
	}
}
