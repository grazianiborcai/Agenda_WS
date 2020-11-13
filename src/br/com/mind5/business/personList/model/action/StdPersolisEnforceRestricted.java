package br.com.mind5.business.personList.model.action;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersolisEnforceRestricted extends ActionStdTemplate<PersolisInfo> {

	public StdPersolisEnforceRestricted(DeciTreeOption<PersolisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<PersolisInfo> buildVisitorHook(DeciTreeOption<PersolisInfo> option) {
		return new VisiPersolisEnforceRestricted(option);
	}
}
