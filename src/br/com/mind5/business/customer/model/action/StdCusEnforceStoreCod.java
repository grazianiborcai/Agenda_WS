package br.com.mind5.business.customer.model.action;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusEnforceStoreCod extends ActionStdTemplate<CusInfo> {

	public StdCusEnforceStoreCod(DeciTreeOption<CusInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CusInfo> buildVisitorHook(DeciTreeOption<CusInfo> option) {
		return new VisiCusEnforceStoreCod(option);
	}
}
