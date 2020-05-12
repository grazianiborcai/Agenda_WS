package br.com.mind5.business.personList.model.action;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersolisEnforceRestricted extends ActionStdTemplateV2<PersolisInfo> {

	public StdPersolisEnforceRestricted(DeciTreeOption<PersolisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PersolisInfo> buildVisitorHook(DeciTreeOption<PersolisInfo> option) {
		return new VisiPersolisEnforceRestricted(option);
	}
}
