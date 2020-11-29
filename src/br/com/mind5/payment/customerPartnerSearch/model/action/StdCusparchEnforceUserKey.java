package br.com.mind5.payment.customerPartnerSearch.model.action;

import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

public final class StdCusparchEnforceUserKey extends ActionStdTemplate<CusparchInfo> {

	public StdCusparchEnforceUserKey(DeciTreeOption<CusparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<CusparchInfo> buildVisitorHook(DeciTreeOption<CusparchInfo> option) {
		return new VisiCusparchEnforceUserKey(option);
	}
}
