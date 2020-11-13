package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplateDaoDelete extends ActionStdTemplate<EmplateInfo> {

	public StdEmplateDaoDelete(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmplateInfo> buildVisitorHook(DeciTreeOption<EmplateInfo> option) {
		return new VisiEmplateDaoDelete(option);
	}
}
