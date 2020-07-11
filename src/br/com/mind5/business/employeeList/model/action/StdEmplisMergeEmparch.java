package br.com.mind5.business.employeeList.model.action;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.model.action.ActionStdTemplateV2;
import br.com.mind5.model.action.ActionVisitorV2;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplisMergeEmparch extends ActionStdTemplateV2<EmplisInfo> {

	public StdEmplisMergeEmparch(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitorV2<EmplisInfo> buildVisitorHook(DeciTreeOption<EmplisInfo> option) {
		return new VisiEmplisMergeEmparch(option);
	}
}
