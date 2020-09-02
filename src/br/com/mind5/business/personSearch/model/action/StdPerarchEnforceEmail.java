package br.com.mind5.business.personSearch.model.action;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPerarchEnforceEmail extends ActionStdTemplateV2<PerarchInfo> {

	public StdPerarchEnforceEmail(DeciTreeOption<PerarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PerarchInfo> buildVisitorHook(DeciTreeOption<PerarchInfo> option) {
		return new VisiPerarchEnforceEmail(option);
	}
}