package br.com.mind5.business.customerSearch.model.action;

import br.com.mind5.business.customerSearch.info.CusarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdCusarchEnforceUserKey extends ActionStdTemplate<CusarchInfo> {

	public StdCusarchEnforceUserKey(DeciTreeOption<CusarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CusarchInfo> buildVisitorHook(DeciTreeOption<CusarchInfo> option) {
		return new VisiCusarchEnforceUserKey(option);
	}
}
