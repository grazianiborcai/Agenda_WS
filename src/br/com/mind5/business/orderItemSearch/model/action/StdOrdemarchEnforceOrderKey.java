package br.com.mind5.business.orderItemSearch.model.action;

import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdOrdemarchEnforceOrderKey extends ActionStdTemplate<OrdemarchInfo> {

	public StdOrdemarchEnforceOrderKey(DeciTreeOption<OrdemarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<OrdemarchInfo> buildVisitorHook(DeciTreeOption<OrdemarchInfo> option) {
		return new VisiOrdemarchEnforceOrderKey(option);
	}
}
