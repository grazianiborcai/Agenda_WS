package br.com.mind5.business.employeeSnapshot.model.action;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

final class StdEmpnapMergePersonap extends ActionStdTemplate<EmpnapInfo> {

	public StdEmpnapMergePersonap(DeciTreeOption<EmpnapInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmpnapInfo> buildVisitorHook(DeciTreeOption<EmpnapInfo> option) {
		return new VisiEmpnapMergePersonap(option);
	}
}
