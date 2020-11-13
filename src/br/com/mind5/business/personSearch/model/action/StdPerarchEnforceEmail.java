package br.com.mind5.business.personSearch.model.action;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerarchEnforceEmail extends ActionStdTemplate<PerarchInfo> {

	public StdPerarchEnforceEmail(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PerarchInfo> buildVisitorHook(DeciTreeOption<PerarchInfo> option) {
		return new VisiPerarchEnforceEmail(option);
	}
}
