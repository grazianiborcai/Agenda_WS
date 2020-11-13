package br.com.mind5.business.employeePosition.model.action;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmposEnforceCreatedBy extends ActionStdTemplate<EmposInfo> {

	public StdEmposEnforceCreatedBy(DeciTreeOption<EmposInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmposInfo> buildVisitorHook(DeciTreeOption<EmposInfo> option) {
		return new VisiEmposEnforceCreatedBy(option);
	}
}
