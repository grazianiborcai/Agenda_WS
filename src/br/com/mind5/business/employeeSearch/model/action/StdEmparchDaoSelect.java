package br.com.mind5.business.employeeSearch.model.action;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.model.action.ActionStdTemplate;
import br.com.mind5.model.action.ActionVisitor;
import br.com.mind5.model.decisionTree.DeciTreeOption;

public final class StdEmparchDaoSelect extends ActionStdTemplate<EmparchInfo> {

	public StdEmparchDaoSelect(DeciTreeOption<EmparchInfo> option) {
		super(option);
	}
	
	
	
	protected ActionVisitor<EmparchInfo> buildVisitorHook(DeciTreeOption<EmparchInfo> option) {
		return new VisiEmparchDaoSelect(option);
	}
}
