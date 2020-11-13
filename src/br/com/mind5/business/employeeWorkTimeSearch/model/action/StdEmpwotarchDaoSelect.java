package br.com.mind5.business.employeeWorkTimeSearch.model.action;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwotarchDaoSelect extends ActionStdTemplate<EmpwotarchInfo> {

	public StdEmpwotarchDaoSelect(DeciTreeOption<EmpwotarchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmpwotarchInfo> buildVisitorHook(DeciTreeOption<EmpwotarchInfo> option) {
		return new VisiEmpwotarchDaoSelect(option);
	}
}
