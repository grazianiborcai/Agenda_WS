package br.com.mind5.business.employeeWorkTimeRange.model.action;

import br.com.mind5.business.employeeWorkTimeRange.info.EmpworgInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpworgDaoSelect extends ActionStdTemplate<EmpworgInfo> {

	public StdEmpworgDaoSelect(DeciTreeOption<EmpworgInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmpworgInfo> buildVisitorHook(DeciTreeOption<EmpworgInfo> option) {
		return new VisiEmpworgDaoSelect(option);
	}
}
