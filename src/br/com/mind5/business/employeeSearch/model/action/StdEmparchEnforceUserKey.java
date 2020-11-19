package br.com.mind5.business.employeeSearch.model.action;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmparchEnforceUserKey extends ActionStdTemplate<EmparchInfo> {

	public StdEmparchEnforceUserKey(DeciTreeOption<EmparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmparchInfo> buildVisitorHook(DeciTreeOption<EmparchInfo> option) {
		return new VisiEmparchEnforceUserKey(option);
	}
}
