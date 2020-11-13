package br.com.mind5.business.employeeList.model.action;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmplisMergeEmparch extends ActionStdTemplate<EmplisInfo> {

	public StdEmplisMergeEmparch(DeciTreeOption<EmplisInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmplisInfo> buildVisitorHook(DeciTreeOption<EmplisInfo> option) {
		return new VisiEmplisMergeEmparch(option);
	}
}
