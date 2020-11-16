package br.com.mind5.business.employeeWorkTime.model.action;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwotmEnforceEmposKey extends ActionStdTemplate<EmpwotmInfo> {

	public StdEmpwotmEnforceEmposKey(DeciTreeOption<EmpwotmInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmpwotmInfo> buildVisitorHook(DeciTreeOption<EmpwotmInfo> option) {
		return new VisiEmpwotmEnforceEmposKey(option);
	}
}
