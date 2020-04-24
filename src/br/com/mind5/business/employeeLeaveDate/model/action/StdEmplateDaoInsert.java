package br.com.mind5.business.employeeLeaveDate.model.action;

import br.com.mind5.business.employeeLeaveDate.info.EmplateInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplateDaoInsert extends ActionStdTemplateV2<EmplateInfo> {

	public StdEmplateDaoInsert(DeciTreeOption<EmplateInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmplateInfo> buildVisitorHook(DeciTreeOption<EmplateInfo> option) {
		return new VisiEmplateDaoInsert(option);
	}
}