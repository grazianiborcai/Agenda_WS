package br.com.mind5.business.employeeWorkTimeOutlier.model.action;

import br.com.mind5.business.employeeWorkTimeOutlier.info.EmpwoutInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmpwoutDaoSelect extends ActionStdTemplate<EmpwoutInfo> {

	public StdEmpwoutDaoSelect(DeciTreeOption<EmpwoutInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmpwoutInfo> buildVisitorHook(DeciTreeOption<EmpwoutInfo> option) {
		return new VisiEmpwoutDaoSelect(option);
	}
}
