package br.com.mind5.business.person.model.action;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdPersonEnforceCreatedBy extends ActionStdTemplateV2<PersonInfo> {

	public StdPersonEnforceCreatedBy(DeciTreeOption<PersonInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<PersonInfo> buildVisitorHook(DeciTreeOption<PersonInfo> option) {
		return new VisiPersonEnforceCreatedBy(option);
	}
}
